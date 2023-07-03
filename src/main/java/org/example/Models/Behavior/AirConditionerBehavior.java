package org.example.Models.Behavior;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.Models.Behavior.BehaviorInterfaces.CoolSystemBehavior;
import org.example.Models.Entities.AirConditionerEntity;
import org.example.Models.Entities.CoolSystemEntity;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Locale;
import java.util.stream.Collectors;

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

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
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
    public ArrayList<AirConditionerEntity> getAirConditioneres(String airConditioner){
        logger.info("getAirConditioneres method search");
        return airConditioneres.stream().filter(item -> item.getId().toString().startsWith(airConditioner.toString()) ||
                                item.getBrand().trim().toUpperCase().contains(airConditioner.trim().toUpperCase()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public boolean buy(CoolSystemEntity coolSystem, int number) throws IOException {
        if (coolSystem.getNumbers() - number >= 0 )
            coolSystem.setNumbers(coolSystem.getNumbers() - number);
        else
            return false;
        AirConditionerEntity airConditioner = (AirConditionerEntity) coolSystem;

        boolean result = writeData("airConditioneres is write new data",airConditioner);
        if (!result){
            airConditioner.setNumbers(airConditioner.getNumbers() + 1);
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
        AirConditionerEntity airConditioner = (AirConditionerEntity) coolSystem;
        remove(airConditioner.getId());
        create(coolSystem);
        return writeData("file edit: " , airConditioner);
    }


    public boolean remove(CoolSystemEntity coolSystem) {
        AirConditionerEntity entity = airConditioneres.stream().filter(item -> coolSystem.getId() == item.getId()).toList().get(0);
        airConditioneres.removeIf(item -> coolSystem.getId().equals(item.getId()));
        boolean result = writeData("one entity of AirConditioner removed",entity);
        if (!result){
            airConditioneres.add(entity);
            return false;
        }
        return true;
    }
    public AirConditionerEntity getAirConditioner(BigInteger id){
        return airConditioneres.stream().filter(item -> item.getId().equals(id)).toList().get(0);
    }
    public boolean remove(BigInteger id){
        AirConditionerEntity airConditioner = airConditioneres.stream().filter(item ->item.getId().equals(id)).toList().get(0);
        boolean result = airConditioneres.removeIf(item -> item.getId().equals(id));
        if (result)
            result = writeData("user deleted :", airConditioner);
        else
            airConditioneres.add(airConditioner);
        return  result;
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
            logger.info("air Conditioneres file created");

        }
        catch (Exception e) {
            logger.fatal(e.getMessage());
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
            logger.fatal(e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage());
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
