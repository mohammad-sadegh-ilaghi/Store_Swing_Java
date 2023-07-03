package org.example.Models.Behavior;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.Models.Behavior.BehaviorInterfaces.CoolSystemBehavior;
import org.example.Models.Entities.AirConditionerEntity;
import org.example.Models.Entities.CoolSystemEntity;
import org.example.Models.Entities.FanEntity;
import org.example.Models.Entities.UserEntity;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

public class FanEntitiyBehavior implements CoolSystemBehavior {
    private String filePath = "src/main/java/org/example/Models/Files/fans.ser";
    private static FanEntitiyBehavior instance;
    private ArrayList<FanEntity> fans;
    private static final Logger logger = LogManager.getLogger(FanEntitiyBehavior.class);
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
    public ArrayList<FanEntity> getFans(String fan){
        logger.info("getAirConditioneres method search");
        return fans.stream().filter(item -> item.getId().toString().startsWith(fan) ||
                        item.getBrand().trim().toUpperCase().contains(fan.trim().toUpperCase()))
                .collect(Collectors.toCollection(ArrayList::new));
    }
    public FanEntity getFan(BigInteger id){
        return fans.stream().filter(item -> item.getId().equals(id)).toList().get(0);
    }

    @Override
    public boolean buy(CoolSystemEntity coolSystem, int number) throws IOException {
        if (coolSystem.getNumbers() - number >= 0 )
            coolSystem.setNumbers(coolSystem.getNumbers() - number);
        else
            return false;
        FanEntity entity = (FanEntity) coolSystem;
        boolean result = write("byuy product: ", entity);
        if (!result){
            entity.setNumbers(entity.getNumbers() + 1);
            return false;
        }
        return true;
    }
    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
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
        fans.removeIf(item -> item.getId().equals(coolSystem.getId()));
        create(fan);
        return write("add fan :", fan);
    }
    public boolean remove(BigInteger id){
        FanEntity fan = fans.stream().filter(item -> item.getId().equals(id)).toList().get(0);
        boolean result = fans.removeIf(item->item.getId().equals(id));
        if (result) {
            try {
                result = write("fans deleted", fan);
            } catch (IOException e) {
                logger.fatal(e.getMessage());
            }
        }
        else
            fans.add(fan);
        return result;
    }

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
        try(FileInputStream fansFile = new FileInputStream(filePath)){
            ObjectInputStream in = new ObjectInputStream(fansFile);
            ArrayList<FanEntity> fakefans = (ArrayList<FanEntity>) in.readObject();
            logger.info("fans from file loaded");
            return fakefans;

        } catch (FileNotFoundException e) {
            File file = new File(filePath);
            file.createNewFile();

            logger.info("fans created");
            return new ArrayList<>();

        } catch (Exception e) {
            logger.fatal(e);
        }
        return null;
    }
    private boolean write(String log, FanEntity fan) throws IOException {
        try(FileOutputStream fileStream = new FileOutputStream(filePath)) {
            ObjectOutputStream out = new ObjectOutputStream(fileStream);
            out.writeObject(fans);
            logger.info(log + fan);
            return  true;
        } catch (FileNotFoundException e) {
            File file = new File(filePath);
            file.createNewFile();
            write(log, fan);
            logger.info("fans created");
        } catch (Exception e) {
            logger.fatal(e.toString());
        }
        return false;
    }
    private boolean resetFile(String log, FanEntity fan) throws IOException {
        try(FileOutputStream fileStream = new FileOutputStream(filePath)) {
            ObjectOutputStream out = new ObjectOutputStream(fileStream);
            fans = new ArrayList<>();
            out.writeObject(fans);
            return  true;
        } catch (FileNotFoundException e) {
            File file = new File(filePath);
            file.createNewFile();
            logger.info("fans created");
        } catch (Exception e) {
            logger.fatal(e.toString());
        }
        return false;
    }
}
