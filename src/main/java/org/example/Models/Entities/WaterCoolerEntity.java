package org.example.Models.Entities;

import org.example.Views.CoolSystem.CoolSystemCreateView;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

public class WaterCoolerEntity extends CoolSystemEntity implements Serializable {
    private String bodyMaterial;
    private String dimention;
    private  String maximumWindPower;
    private String PumpPower;
    private String comsumptionWaterPeerHours;
    private boolean remoteController;

    public WaterCoolerEntity(CoolSystemEntity coolSystem,  String bodyMaterial, String dimention, String maximumWindPower, String pumpPower, String comsumptionWaterPeerHours, boolean remoteController){
        super(coolSystem);
        this.bodyMaterial = bodyMaterial;
        this.dimention = dimention;
        this.maximumWindPower = maximumWindPower;
        PumpPower = pumpPower;
        this.comsumptionWaterPeerHours = comsumptionWaterPeerHours;
        this.remoteController = remoteController;
    }
    public WaterCoolerEntity(String brand, LocalDate dateOfCreated, String made, int numbers, String power, boolean isNew, LocalDate warranty, String energyLabel, String weight, String bodyMaterial, String dimention, String maximumWindPower, String pumpPower, String comsumptionWaterPeerHours, boolean remoteController) {
        super(brand, dateOfCreated, made, numbers, power, isNew, warranty, energyLabel, weight);
        this.bodyMaterial = bodyMaterial;
        this.dimention = dimention;
        this.maximumWindPower = maximumWindPower;
        PumpPower = pumpPower;
        this.comsumptionWaterPeerHours = comsumptionWaterPeerHours;
        this.remoteController = remoteController;
    }

    public String getBodyMaterial() {
        return bodyMaterial;
    }

    public void setBodyMaterial(String bodyMaterial) {
        this.bodyMaterial = bodyMaterial;
    }

    public String getDimention() {
        return dimention;
    }

    public void setDimention(String dimention) {
        this.dimention = dimention;
    }

    public String getMaximumWindPower() {
        return maximumWindPower;
    }

    public void setMaximumWindPower(String maximumWindPower) {
        this.maximumWindPower = maximumWindPower;
    }

    public String getPumpPower() {
        return PumpPower;
    }

    public void setPumpPower(String pumpPower) {
        PumpPower = pumpPower;
    }

    public String getComsumptionWaterPeerHours() {
        return comsumptionWaterPeerHours;
    }

    public void setComsumptionWaterPeerHours(String comsumptionWaterPeerHours) {
        this.comsumptionWaterPeerHours = comsumptionWaterPeerHours;
    }

    public boolean getRemoteController() {
        return remoteController;
    }

    public void setRemoteController(boolean remoteController) {
        this.remoteController = remoteController;
    }

    @Override
    public String toString() {
        return "WaterCoolerEntity{" +
                "bodyMaterial='" + bodyMaterial + '\'' +
                ", dimention='" + dimention + '\'' +
                ", maximumWindPower='" + maximumWindPower + '\'' +
                ", PumpPower='" + PumpPower + '\'' +
                ", comsumptionWaterPeerHours='" + comsumptionWaterPeerHours + '\'' +
                ", remoteController='" + remoteController + '\'' +
                '}';
    }
    public String toStringFile() {
        return super.toStringFile() + '\t' +bodyMaterial + '\t' +
                   dimention + '\t' +
                   maximumWindPower + '\t' +
                   PumpPower + '\t' +
                   comsumptionWaterPeerHours + '\t' +
                   remoteController + '\t';
    }
    public static String[] getFeilds() {
        Field[] fields = FieldsEntity.getAllFields(WaterCoolerEntity.class);
        return Arrays.stream(fields)
                .map(Field::getName)
                .map(item -> item.replaceAll("(\\p{Lower})(\\p{Upper})", "$1 $2"))
                .toArray(String[]::new);
    }
}
