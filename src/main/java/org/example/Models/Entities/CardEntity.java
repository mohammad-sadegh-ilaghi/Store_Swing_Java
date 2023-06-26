package org.example.Models.Entities;

public class CardEntity {
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
        this.inventory = inventory;
    }
}