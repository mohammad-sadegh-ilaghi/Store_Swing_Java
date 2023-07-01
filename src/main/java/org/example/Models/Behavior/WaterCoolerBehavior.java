package org.example.Models.Behavior;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.Models.Behavior.BehaviorInterfaces.CoolSystemBehavior;
import org.example.Models.Entities.CoolSystemEntity;
import org.example.Models.Entities.FanEntity;
import org.example.Models.Entities.WaterCoolerEntity;

import java.io.*;
import java.math.BigInteger;
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
    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    @Override
    public boolean buy(CoolSystemEntity coolSystem) {
        for (WaterCoolerEntity item : watercooleres){
            if (item.getId().equals(coolSystem.getId())){
                item.setNumbers(item.getNumbers() - 1);
                try {
                    write("buy one product", (WaterCoolerEntity) coolSystem);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                return true;
            }
        }
        return false;
    }

    public ArrayList<WaterCoolerEntity> getWatercooleres() {
        return watercooleres;
    }
    public WaterCoolerEntity getWatercooler(BigInteger id) {
        return watercooleres.stream().filter(item -> item.getId().equals(id)).toList().get(0);
    }

    @Override
    public boolean create(CoolSystemEntity coolSystem) {
        WaterCoolerEntity waterCooler = (WaterCoolerEntity) coolSystem;
        watercooleres.add(waterCooler);
        boolean result = true;
        try {
            result = write("add waterCooler Product :", waterCooler);
        } catch (IOException e) {
            logger.fatal(e);
        }
        if (!result){
            watercooleres.removeIf(item -> item.getId().equals(waterCooler.getId()));
            return result;
        }
        return result;
    }

    @Override
    public boolean edit(CoolSystemEntity coolSystem) {
        WaterCoolerEntity waterCooler = (WaterCoolerEntity) coolSystem;
        boolean result = remove(waterCooler.getId());
        if (result){
            result = create(waterCooler);
        }
        return result;
    }

    @Override
    public boolean remove(BigInteger id) {
        WaterCoolerEntity waterCooler = watercooleres.stream().filter(item -> item.getId().equals(id)).toList().get(0);
        boolean result = watercooleres.removeIf(item -> item.getId().equals(waterCooler.getId()));
        if (result){
            try {
                result = write("waterCooler removed: ", waterCooler);
            } catch (IOException e) {
                logger.fatal(e.getMessage());
            }
        }
        else
            watercooleres.add(waterCooler);
        return result;
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
