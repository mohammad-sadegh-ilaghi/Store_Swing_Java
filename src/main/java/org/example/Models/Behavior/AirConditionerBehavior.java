package org.example.Models.Behavior;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.Models.Behavior.BehaviorInterfaces.CoolSystemBehavior;
import org.example.Models.Entities.AirConditionerEntity;
import org.example.Models.Entities.CoolSystemEntity;

import java.io.*;
import java.util.ArrayList;

public class AirConditionerBehavior implements CoolSystemBehavior {
    private String filePath ="src/main/java/org/example/Models/Files/airConditioner.ser";
    private static AirConditionerBehavior instance;
    private ArrayList<AirConditionerEntity> airConditioneres;
    private static final Logger logger = LogManager.getLogger(AirConditionerBehavior.class);

    public static AirConditionerBehavior singelton() throws IOException {
        if (instance ==null)
            instance = new AirConditionerBehavior();
        return instance;
    }

    private AirConditionerBehavior() throws IOException {
        airConditioneres = readAirConditionFromFile();
        if (airConditioneres == null)
            airConditioneres = new ArrayList<>();
            logger.fatal("file can not read and create");
    }

    public ArrayList<AirConditionerEntity> getAirConditioneres() {
        logger.info("getAirConditioneres method called");
        return airConditioneres;
    }


    @Override
    public boolean buy(CoolSystemEntity coolSystem) throws IOException {

        AirConditionerEntity airConditionerEntity = airConditioneres.stream().filter(item -> item.getId() == coolSystem.getId()).toList().get(0);
        airConditionerEntity.setNumbers(airConditionerEntity.getNumbers() - 1);
        boolean result = writeData("airConditioneres is write new data",airConditionerEntity);
        if (!result){
            airConditionerEntity.setNumbers(airConditionerEntity.getNumbers() + 1);
            return false;
        }
        return true;
    }

    @Override
    public boolean create(CoolSystemEntity coolSystem) {
        AirConditionerEntity airConditionerEntity = (AirConditionerEntity) coolSystem;
        airConditioneres.add(airConditionerEntity);
        boolean result = writeData("airConditioneres is write new data",airConditionerEntity);
        if (!result){
            airConditioneres.removeIf(item -> coolSystem.getId() == item.getId());
            return false;
        }
        return true;
    }

    @Override
    public boolean edit(CoolSystemEntity coolSystem) {
        AirConditionerEntity airConditionerEntity = airConditioneres.stream().filter(item -> item.getId() == coolSystem.getId()).toList().get(0);
        airConditionerEntity = (AirConditionerEntity) coolSystem;
        return writeData("file edit: " , airConditionerEntity);
    }

    @Override
    public boolean remove(CoolSystemEntity coolSystem) {
        AirConditionerEntity entity = airConditioneres.stream().filter(item -> coolSystem.getId() == item.getId()).toList().get(0);
        airConditioneres.removeIf(item -> coolSystem.getId() == item.getId() );
        boolean result = writeData("one entity of AirConditioner removed",entity);
        if (!result){
            airConditioneres.add(entity);
            return false;
        }
        return true;
    }
    private boolean writeData(String log, AirConditionerEntity airConditionerEntity){
        try(FileOutputStream airConditionerFile = new FileOutputStream(filePath)){
            ObjectOutputStream in = new ObjectOutputStream(airConditionerFile);
            in.writeObject(airConditioneres);
            logger.info(log + airConditionerEntity.toString());
        }catch (FileNotFoundException e) {
            File file = new File(filePath);
            try {
                file.createNewFile();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            writeData(log, airConditionerEntity);
            logger.info("airConditioneres file created");

        }
        catch (Exception e) {
            logger.fatal(e.toString());
            return false;
        }
        return true;
    }
    private ArrayList<AirConditionerEntity> readAirConditionFromFile() throws IOException {
        try(FileInputStream airConditionerFile = new FileInputStream(filePath)){
            ObjectInputStream in = new ObjectInputStream(airConditionerFile);
            ArrayList<AirConditionerEntity> list = (ArrayList<AirConditionerEntity>) in.readObject();
            logger.info("airConditioneres file loaded");
            return list;
        } catch (FileNotFoundException e) {
            File file = new File(filePath);
            file.createNewFile();
            logger.info("airConditioneres file created");

        } catch (IOException e) {
            logger.fatal(e.toString());
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return new ArrayList<>();
    }
    public boolean removeDataFromFile() throws IOException {
        try (FileOutputStream file = new FileOutputStream(filePath)){
            ObjectOutputStream out = new ObjectOutputStream(file);
            airConditioneres = new ArrayList<>();
            out.writeObject(airConditioneres);
            logger.info("file removed data.");
            return true;
        } catch (FileNotFoundException e) {
            File file = new File(filePath);
            file.createNewFile();
            logger.fatal("can not find file of user");
        } catch (Exception e) {
            logger.fatal(e.getMessage());
        }
        return false;
    }
}
