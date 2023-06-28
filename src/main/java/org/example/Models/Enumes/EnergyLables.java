package org.example.Models.Enumes;

public enum EnergyLables {
    A("A"),
    APLUS("A"),
    B("B"),
    C("C"),
    D("D"),
    E("E");


    private final String stringValue;

    EnergyLables(String stringValue) {
        this.stringValue = stringValue;
    }

    public String toString() {
        return stringValue;
    }
    public String getStringValue() {
        return stringValue;
    }

}
