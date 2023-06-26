package org.example.Models.Behavior;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.Models.Behavior.BehaviorInterfaces.CoolSystemBehavior;
import org.example.Models.Entities.CoolSystemEntity;
import org.example.Models.Entities.FanEntity;
import org.example.Models.Entities.UserEntity;

import java.io.*;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

public class FanEntitiyBehavior implements CoolSystemBehavior {
    private static FanEntitiyBehavior instance;
    private ArrayList<FanEntity> fans;
    private static final Logger logger = LogManager.getLogger(AirConditionerBehavior.class);
    public static FanEntitiyBehavior singelton() throws IOException {
            if (instance ==null)
                instance = new FanEntitiyBehavior();
            return instance;
    }
    private FanEntitiyBehavior() throws IOException {
        fans = read();
        if (fans == null){
            logger.fatal("file can not read and create");
            fans = new ArrayList<>();
        }
    }

    public ArrayList<FanEntity> getFans() {
        return fans;
    }


    @Override
    public boolean buy(CoolSystemEntity coolSystem) throws IOException {
        coolSystem.setNumbers(coolSystem.getNumbers() - 1);
        FanEntity entity = (FanEntity) coolSystem;
        boolean result = write("byuy product: ", entity);
        if (!result){
            entity.setNumbers(entity.getNumbers() + 1);
            return false;
        }
        return true;
    }

    @Override
    public boolean create(CoolSystemEntity coolSystem) throws IOException {
        FanEntity fan = (FanEntity) coolSystem;
        this.fans.add(fan);
        boolean result = write("add fan :", fan);
        if (!result)
        {
            fans.removeIf(item -> item.getId() == fan.getId());
            return false;
        }
        return true;
    }


    @Override
    public boolean edit(CoolSystemEntity coolSystem) throws IOException {
        FanEntity fan = (FanEntity) coolSystem;
        FanEntity mainFan = fans.stream().filter(item -> item.getId() == item.getId()).collect(Collectors.toList()).get(0);
        mainFan = fan;
        boolean result = write("add fan :", fan);
        if (!result)
            return false;
        return true;
    }

    @Override
    public boolean remove(CoolSystemEntity coolSystem) throws IOException {
        FanEntity fan = fans.stream().filter(item -> item.getId() == item.getId()).toList().get(0);
        if (fan == null)
            return false;
        fans.removeIf(item -> item.getId() == coolSystem.getId());
        boolean result = write("remove fan:", fan);
        if (!result){
            fans.add(fan);
            return false;
        }
        return true;
    }
    private ArrayList<FanEntity> read() throws IOException {
        try(FileInputStream fansFile = new FileInputStream("../../Files/fans.txt")){
            ObjectInputStream in = new ObjectInputStream(fansFile);
            ArrayList<FanEntity> fakefans = (ArrayList<FanEntity>) in.readObject();
            logger.info("fans from file loaded");
            return fakefans;

        } catch (FileNotFoundException e) {
            File file = new File("../../Files/fans.txt");
            file.createNewFile();

            logger.info("fans created");
            return new ArrayList<>();

        } catch (Exception e) {
            logger.fatal(e);
        }
        return null;
    }
    private boolean write(String log, FanEntity fan) throws IOException {
        try(FileOutputStream fileStream = new FileOutputStream("../../Files/fans.txt")) {
            ObjectOutputStream out = new ObjectOutputStream(fileStream);
            out.writeObject(fans);
            logger.info(log + fan);
            return  true;
        } catch (FileNotFoundException e) {
            File file = new File("../../Files/fans.txt");
            file.createNewFile();
            logger.info("fans created");
        } catch (Exception e) {
            logger.fatal(e.toString());
        }
        return false;
    }
}
