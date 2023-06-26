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
    private static WaterCoolerBehavior instance;
    private ArrayList<WaterCoolerEntity> watercooleres;
    private static final Logger logger = LogManager.getLogger(AirConditionerBehavior.class);

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
        try(FileInputStream usersFile = new FileInputStream("../../Files/waterCooler.txt")){
            ObjectInputStream in = new ObjectInputStream(usersFile);
            ArrayList<WaterCoolerEntity> watercooleresFake = (ArrayList<WaterCoolerEntity>) in.readObject();
            logger.info("file waterCooler readed");
            return watercooleresFake;
        } catch (FileNotFoundException e) {
            File file = new File("../../Files/waterCooler.txt");
            file.createNewFile();
            logger.info("file waterCooler created");

            return new ArrayList<>();
        } catch (Exception e) {
          logger.fatal(e.toString());
        }
        return null;
    }
}
