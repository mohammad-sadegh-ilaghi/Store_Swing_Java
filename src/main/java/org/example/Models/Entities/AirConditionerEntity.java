package org.example.Models.Entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class AirConditionerEntity extends CoolSystemEntity implements Serializable {
    private String theOutputIsTwoWay;
    private String coolingCapacityBTUh;
    private String coolingCapacityKw;
    private String heatingCapacityBTUh;
    private String threeRowCoil;

    public AirConditionerEntity(String brand, LocalDate dateOfCreated, String made, int numbers, String power, boolean isNew, LocalDate warranty, String energyLabel, String weight, String theOutputIsTwoWay, String coolingCapacityBTUh, String coolingCapacityKw, String heatingCapacityBTUh, String threeRowCoil) {
        super(brand, dateOfCreated, made, numbers, power, isNew, warranty, energyLabel, weight);

        this.theOutputIsTwoWay = theOutputIsTwoWay;
        this.coolingCapacityBTUh = coolingCapacityBTUh;
        this.coolingCapacityKw = coolingCapacityKw;
        this.heatingCapacityBTUh = heatingCapacityBTUh;
        this.threeRowCoil = threeRowCoil;
    }

    @Override
    public boolean equals(Object obj) {
        AirConditionerEntity airConditioner = (AirConditionerEntity) obj;
        if (getId() == airConditioner.getId())
            return true;
        return false;
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
        return threeRowCoil;
    }

    public void setThreeRowCoil(String threeRowCoil) {
        this.threeRowCoil = threeRowCoil;
    }

    @Override
    public String toString() {
        return "AirConditionerEntity{" +
                "theOutputIsTwoWay='" + theOutputIsTwoWay + '\'' +
                ", coolingCapacityBTUh='" + coolingCapacityBTUh + '\'' +
                ", coolingCapacityKw='" + coolingCapacityKw + '\'' +
                ", heatingCapacityBTUh='" + heatingCapacityBTUh + '\'' +
                ", ThreeRowCoil='" + threeRowCoil + '\'' +
                super.toString() +
                '}';
    }
}
