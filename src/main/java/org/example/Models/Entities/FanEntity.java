package org.example.Models.Entities;

import java.io.Serializable;
import java.util.Date;

public class FanEntity extends CoolSystemEntity implements Serializable {
    private int length;
    private String type;
    private boolean haveremoteController;
    private String dimension;
    private String windVolume;
    private String lengthOfCable;

    public FanEntity(String photo, String brand, Date dateOfCreated, String made, int numbers, String power, boolean isNew, Date warranty, String energyLabel, String weight, int length, String type, boolean haveremoteController, String dimension, String windVolume, String lengthOfCable) {
        super(photo, brand, dateOfCreated, made, numbers, power, isNew, warranty, energyLabel, weight);
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

    public String getLengthOfCable() {
        return lengthOfCable;
    }

    public void setLengthOfCable(String lengthOfCable) {
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
}
