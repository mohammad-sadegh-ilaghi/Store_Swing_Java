package org.example.Models.Entities;

import org.example.Views.CoolSystem.CoolSystemCreateView;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.UUID;

public class CoolSystemEntity implements Serializable {
    private String brand;
    private BigInteger id;

    private LocalDate dateOfCreated;
    private String made;
    private int numbers;
    private  String power;
    private boolean isNew;
    private LocalDate warranty;
    private String EnergyLabel;
    private String weight;

    public CoolSystemEntity(String brand, LocalDate dateOfCreated, String made, int numbers, String power, boolean isNew, LocalDate warranty, String energyLabel, String weight) {
        this.brand = brand;
        this.dateOfCreated = dateOfCreated;
        this.made = made;
        this.numbers = numbers;
        this.power = power;
        this.isNew = isNew;
        this.warranty = warranty;
        EnergyLabel = energyLabel;
        this.weight = weight;

// Generate a unique integer value
        id = new BigInteger(String.format("%010d",new BigInteger(UUID.randomUUID().toString().replace("-",""),16)));
    }

    public CoolSystemEntity(CoolSystemEntity coolSystem) {
        this.brand = coolSystem.getBrand();
        this.dateOfCreated = coolSystem.dateOfCreated;
        this.made = coolSystem.getMade();
        this.numbers = coolSystem.getNumbers();
        this.power = coolSystem.getPower();
        this.isNew = coolSystem.isNew();
        this.warranty = coolSystem.getWarranty();
        EnergyLabel = coolSystem.getEnergyLabel();
        this.weight = coolSystem.getWeight();
// Generate a unique integer value
        id = new BigInteger(String.format("%010d",new BigInteger(UUID.randomUUID().toString().replace("-",""),16)));
    }


    public BigInteger getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMade() {
        return made;
    }

    public void setMade(String made) {
        this.made = made;
    }

    public int getNumbers() {
        return numbers;
    }

    public void setNumbers(int numbers) {
        this.numbers = numbers;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public LocalDate getWarranty() {
        return warranty;
    }

    public void setWarranty(LocalDate warranty) {
        this.warranty = warranty;
    }

    public String getEnergyLabel() {
        return EnergyLabel;
    }

    public void setEnergyLabel(String energyLabel) {
        EnergyLabel = energyLabel;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
    public LocalDate getDateOfCreated() {
        return dateOfCreated;
    }

    public void setDateOfCreated(LocalDate dateOfCreated) {

        this.dateOfCreated = dateOfCreated;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CoolSystemEntity{" +
                "brand='" + brand + '\'' +
                ", id=" + id +
                ", dateOfCreated=" + dateOfCreated +
                ", made='" + made + '\'' +
                ", numbers=" + numbers +
                ", power='" + power + '\'' +
                ", isNew=" + isNew +
                ", warranty=" + warranty +
                ", EnergyLabel='" + EnergyLabel + '\'' +
                ", weight='" + weight + '\'' +
                '}';
    }
    public String toStringFile(){
        return  brand + '\t' +
                id + "\t" +
                dateOfCreated + + '\t' +
                made + '\t' +
                numbers + '\t' +
                power + '\t' +
                isNew + '\t' +
                warranty + '\t' +
                EnergyLabel + '\t' +
                weight + '\t';
    }
    public static String[] getFeilds() {
        Field[] fields = FieldsEntity.getAllFields(CoolSystemEntity.class);
        return Arrays.stream(fields)
                .map(Field::getName)
                .map(item -> item.replaceAll("(\\p{Lower})(\\p{Upper})", "$1 $2"))
                .toArray(String[]::new);
    }
}
