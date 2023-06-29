package org.example.Models.Entities;

import java.io.Serializable;

public class    ProductBought implements Serializable {
    private UserEntity user;
    private CoolSystemEntity coolSystem;
    private int numbers= 0;


    public ProductBought(UserEntity user, CoolSystemEntity coolSystem) {
        this.user = user;
        this.coolSystem = coolSystem;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public CoolSystemEntity getCoolSystem() {
        return coolSystem;
    }

    public void setCoolSystem(CoolSystemEntity coolSystem) {
        this.coolSystem = coolSystem;
    }

    @Override
    public boolean equals(Object obj) {
        ProductBought productBought = (ProductBought) obj;
        return productBought.getCoolSystem().getId().equals(coolSystem.getId())
                    && productBought.getUser().getUserName().equals(productBought.getUser().getUserName());
    }
    public void buy(){
        numbers++;
    }

    public int getNumbers() {
        return numbers;
    }
}
