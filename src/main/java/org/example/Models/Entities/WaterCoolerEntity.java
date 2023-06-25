package org.example.Models.Entities;

import java.util.Date;

public class WaterCoolerEntity extends CoolSystemEntity{
    private String bodyMaterial;
    private String dimention;
    private  String maximumWindPower;
    private String PumpPower;
    private String comsumptionWaterPeerHours;
    private String remoteController;
    private String airConditionerFacilities;
    private String inverter;
    private String eERCoolingEfficiency;
    private String cOPHeatingEfficiency;
    private int numberOfPanels;
    private String type;
    private String internalPanelMaterial;

    public WaterCoolerEntity(String photo, String brand, Date dateOfCreated, String made, int numbers, String power, boolean isNew, Date warranty, String energyLabel, String weight, String bodyMaterial, String dimention, String maximumWindPower, String pumpPower, String comsumptionWaterPeerHours, String remoteController, String airConditionerFacilities, String inverter, String eERCoolingEfficiency, String cOPHeatingEfficiency, int numberOfPanels, String type, String internalPanelMaterial) {
        super(photo, brand, dateOfCreated, made, numbers, power, isNew, warranty, energyLabel, weight);
        this.bodyMaterial = bodyMaterial;
        this.dimention = dimention;
        this.maximumWindPower = maximumWindPower;
        PumpPower = pumpPower;
        this.comsumptionWaterPeerHours = comsumptionWaterPeerHours;
        this.remoteController = remoteController;
        this.airConditionerFacilities = airConditionerFacilities;
        this.inverter = inverter;
        this.eERCoolingEfficiency = eERCoolingEfficiency;
        this.cOPHeatingEfficiency = cOPHeatingEfficiency;
        this.numberOfPanels = numberOfPanels;
        this.type = type;
        this.internalPanelMaterial = internalPanelMaterial;
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

    public String getRemoteController() {
        return remoteController;
    }

    public void setRemoteController(String remoteController) {
        this.remoteController = remoteController;
    }

    public String getAirConditionerFacilities() {
        return airConditionerFacilities;
    }

    public void setAirConditionerFacilities(String airConditionerFacilities) {
        this.airConditionerFacilities = airConditionerFacilities;
    }

    public String getInverter() {
        return inverter;
    }

    public void setInverter(String inverter) {
        this.inverter = inverter;
    }

    public String geteERCoolingEfficiency() {
        return eERCoolingEfficiency;
    }

    public void seteERCoolingEfficiency(String eERCoolingEfficiency) {
        this.eERCoolingEfficiency = eERCoolingEfficiency;
    }

    public String getcOPHeatingEfficiency() {
        return cOPHeatingEfficiency;
    }

    public void setcOPHeatingEfficiency(String cOPHeatingEfficiency) {
        this.cOPHeatingEfficiency = cOPHeatingEfficiency;
    }

    public int getNumberOfPanels() {
        return numberOfPanels;
    }

    public void setNumberOfPanels(int numberOfPanels) {
        this.numberOfPanels = numberOfPanels;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInternalPanelMaterial() {
        return internalPanelMaterial;
    }

    public void setInternalPanelMaterial(String internalPanelMaterial) {
        this.internalPanelMaterial = internalPanelMaterial;
    }
}
