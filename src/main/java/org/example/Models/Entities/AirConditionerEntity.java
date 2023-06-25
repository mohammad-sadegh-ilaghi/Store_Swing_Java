package org.example.Models.Entities;

import java.util.Date;

public class AirConditionerEntity extends CoolSystemEntity {
    private String theOutputIsTwoWay;
    private String coolingCapacityBTUh;
    private String coolingCapacityKw;
    private String heatingCapacityBTUh;
    private String ThreeRowCoil;

    public AirConditionerEntity(String brand, Date dateOfCreated, String made, int numbers, String photo, String power, boolean isNew, Date warranty, String energyLabel, String weight, String theOutputIsTwoWay, String coolingCapacityBTUh, String coolingCapacityKw, String heatingCapacityBTUh, String threeRowCoil) {
        super(photo, brand, dateOfCreated, made, numbers, power, isNew, warranty, energyLabel, weight);

        this.theOutputIsTwoWay = theOutputIsTwoWay;
        this.coolingCapacityBTUh = coolingCapacityBTUh;
        this.coolingCapacityKw = coolingCapacityKw;
        this.heatingCapacityBTUh = heatingCapacityBTUh;
        ThreeRowCoil = threeRowCoil;
    }

    public String getTheOutputIsTwoWay() {
        return theOutputIsTwoWay;
    }

    public void setTheOutputIsTwoWay(String theOutputIsTwoWay) {
        this.theOutputIsTwoWay = theOutputIsTwoWay;
    }

    public String getCoolingCapacityBTUh() {
        return coolingCapacityBTUh;
    }

    public void setCoolingCapacityBTUh(String coolingCapacityBTUh) {
        this.coolingCapacityBTUh = coolingCapacityBTUh;
    }

    public String getCoolingCapacityKw() {
        return coolingCapacityKw;
    }

    public void setCoolingCapacityKw(String coolingCapacityKw) {
        this.coolingCapacityKw = coolingCapacityKw;
    }

    public String getHeatingCapacityBTUh() {
        return heatingCapacityBTUh;
    }

    public void setHeatingCapacityBTUh(String heatingCapacityBTUh) {
        this.heatingCapacityBTUh = heatingCapacityBTUh;
    }

    public String getThreeRowCoil() {
        return ThreeRowCoil;
    }

    public void setThreeRowCoil(String threeRowCoil) {
        ThreeRowCoil = threeRowCoil;
    }
}
