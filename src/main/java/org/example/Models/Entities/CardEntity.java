package org.example.Models.Entities;

import java.io.Serializable;

public class CardEntity implements Serializable {
    private int IdCard;
    private String bank;
    private int inventory;

    public CardEntity(int idCard, String bank, int inventory) {
        IdCard = idCard;
        this.bank = bank;
        this.inventory = inventory;
    }

    public int getIdCard() {
        return IdCard;
    }

    public String getBank() {
        return bank;
    }


    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory += inventory;
    }

    public void setIdCard(int idCard) {
        IdCard = idCard;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }
}
