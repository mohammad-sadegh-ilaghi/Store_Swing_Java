package org.example.Models.Entities;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class CoolSystemEntity {
    private String brand;
    private int id;

    private Date dateOfCreated;
    private String made;
    private int numbers;
    private  String power;
    private boolean isNew;
    private String photo;
    private Date warranty;
    private String EnergyLabel;
    private String weight;

    public CoolSystemEntity(String photo, String brand, Date dateOfCreated, String made, int numbers, String power, boolean isNew, Date warranty, String energyLabel, String weight) {
        this.brand = brand;
        this.dateOfCreated = dateOfCreated;
        this.made = made;
        this.numbers = numbers;
        this.power = power;
        this.isNew = isNew;
        this.warranty = warranty;
        EnergyLabel = energyLabel;
        this.weight = weight;
        this.photo = photo;
        AtomicInteger uniqueId = new AtomicInteger(0);

// Generate a unique integer value
        id = uniqueId.getAndIncrement();
    }

    public int getId() {
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

    public Date getWarranty() {
        return warranty;
    }

    public void setWarranty(Date warranty) {
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
    public Date getDateOfCreated() {
        return dateOfCreated;
    }

    public void setDateOfCreated(Date dateOfCreated) {

        this.dateOfCreated = dateOfCreated;
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
                ", photo='" + photo + '\'' +
                ", warranty=" + warranty +
                ", EnergyLabel='" + EnergyLabel + '\'' +
                ", weight='" + weight + '\'' +
                '}';
    }
}
