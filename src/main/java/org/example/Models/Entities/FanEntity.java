package org.example.Models.Entities;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

public class FanEntity extends CoolSystemEntity implements Serializable {
    private int length;
    private String type;
    private boolean haveremoteController;
    private String dimension;
    private String windVolume;
    private int lengthOfCable;

    public FanEntity(String brand, LocalDate dateOfCreated, String made, int numbers, String power, boolean isNew, LocalDate warranty, String energyLabel, String weight, int length, String type, boolean haveremoteController, String dimension, String windVolume, int lengthOfCable) {
        super(brand, dateOfCreated, made, numbers, power, isNew, warranty, energyLabel, weight);
        this.length = length;
        this.type = type;
        this.haveremoteController = haveremoteController;
        this.dimension = dimension;
        this.windVolume = windVolume;
        this.lengthOfCable = lengthOfCable;
    }
    public FanEntity(CoolSystemEntity coolSystem ,int length, String type, boolean haveremoteController, String dimension, String windVolume, int lengthOfCable) {
        super(coolSystem);
        this.length = length;
        this.type = type;
        this.haveremoteController = haveremoteController;
        this.dimension = dimension;
        this.windVolume = windVolume;
        this.lengthOfCable = lengthOfCable;
    }
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isHaveremoteController() {
        return haveremoteController;
    }

    public void setHaveremoteController(boolean haveremoteController) {
        this.haveremoteController = haveremoteController;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getWindVolume() {
        return windVolume;
    }

    public void setWindVolume(String windVolume) {
        this.windVolume = windVolume;
    }

    public int getLengthOfCable() {
        return lengthOfCable;
    }

    public void setLengthOfCable(int lengthOfCable) {
        this.lengthOfCable = lengthOfCable;
    }

    @Override
    public String toString() {
        return "FanEntity{" +
                "length=" + length +
                ", type='" + type + '\'' +
                ", haveremoteController=" + haveremoteController +
                ", dimension='" + dimension + '\'' +
                ", windVolume='" + windVolume + '\'' +
                ", lengthOfCable='" + lengthOfCable + '\'' +
                '}';
    }

    public String toStringFile() {
        return  super.toStringFile() + '\t' + length + '\t' +
               type + '\t' +
               haveremoteController + '\t' +
               dimension + '\t' +
               windVolume + '\t' +
               lengthOfCable + '\t';
    }
    public static String[] getFeilds() {
        Field[] fields = FieldsEntity.getAllFields(FanEntity.class);
        return Arrays.stream(fields)
                .map(Field::getName)
                .map(item -> item.replaceAll("(\\p{Lower})(\\p{Upper})", "$1 $2"))
                .toArray(String[]::new);
    }

}
