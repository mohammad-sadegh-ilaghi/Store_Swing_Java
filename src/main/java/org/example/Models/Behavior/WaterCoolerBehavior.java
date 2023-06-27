package org.example.Models.Behavior;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.Models.Behavior.BehaviorInterfaces.CoolSystemBehavior;
import org.example.Models.Entities.CoolSystemEntity;
import org.example.Models.Entities.FanEntity;
import org.example.Models.Entities.WaterCoolerEntity;

import java.io.*;
import java.util.ArrayList;

public class WaterCoolerBehavior implements CoolSystemBehavior {
    private  String filePath = "src/main/java/org/example/Models/Files/waterCooler.ser";
    private static WaterCoolerBehavior instance;
    private ArrayList<WaterCoolerEntity> watercooleres;
    private static final Logger logger = LogManager.getLogger(WaterCoolerBehavior.class);

    public  static WaterCoolerBehavior singelton() throws IOException {
        if (instance == null)
            instance = new WaterCoolerBehavior();
        return instance;
    }
    private WaterCoolerBehavior() throws IOException {
        watercooleres = read();
        if (watercooleres == null){
            watercooleres = new ArrayList<>();
            logger.fatal("file can not read and create");
        }
    }
    @Override
    public boolean buy(CoolSystemEntity coolSystem) {
        return false;
    }

    @Override
    public boolean create(CoolSystemEntity coolSystem) {
        return false;
    }

    @Override
    public boolean edit(CoolSystemEntity coolSystem) {
        return false;
    }

    @Override
    public boolean remove(CoolSystemEntity coolSystem) {
        return false;
    }
    private ArrayList<WaterCoolerEntity> read() throws IOException {
        try(FileInputStream usersFile = new FileInputStream(filePath)){
            ObjectInputStream in = new ObjectInputStream(usersFile);
            ArrayList<WaterCoolerEntity> watercooleresFake = (ArrayList<WaterCoolerEntity>) in.readObject();
            logger.info("file waterCooler readed");
            return watercooleresFake;
        } catch (FileNotFoundException e) {
            File file = new File(filePath);
            file.createNewFile();
            logger.info("file waterCooler created");

            return new ArrayList<>();
        } catch (Exception e) {
          logger.fatal(e.toString());
        }
        return null;
    }
    private boolean write(String log, WaterCoolerEntity waterCoolerEntity) throws IOException {
        try(FileOutputStream waterCoolFile = new FileOutputStream(filePath)){
            ObjectOutputStream out = new ObjectOutputStream(waterCoolFile);
            out.writeObject(watercooleres);
            logger.info("file waterCooler writed");
            return true;
        } catch (FileNotFoundException e) {
            File file = new File(filePath);
            file.createNewFile();
            write(log, waterCoolerEntity);
            logger.info("file waterCooler created");
            return true;
        } catch (Exception e) {
            logger.fatal(e.toString());
        }
        return false;
    }
    private boolean resetFile() throws IOException {
        try(FileOutputStream waterCoolFile = new FileOutputStream(filePath)){
            ObjectOutputStream out = new ObjectOutputStream(waterCoolFile);
            watercooleres = new ArrayList<>();
            out.writeObject(watercooleres);
            logger.info("file waterCooler writed");
            return true;
        } catch (FileNotFoundException e) {
            File file = new File(filePath);
            file.createNewFile();
            logger.info("file waterCooler created");
            return true;
        } catch (Exception e) {
            logger.fatal(e.toString());
        }
        return false;
    }
}
