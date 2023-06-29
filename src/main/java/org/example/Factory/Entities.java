package org.example.Factory;

public enum Entities {

    AirConditioner("AirConditioner"),
    Fans("Fans"),
    WaterCooler("WaterCooler"),
    ;
    private final String stringValue;


    Entities(String type) {
        this.stringValue = type;
    }

    public String toString() {
        return stringValue;
    }
    public String getStringValue() {
        return stringValue;
    }

}
