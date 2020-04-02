package com.example.c2ldeliveryboy.View.Model;

public class Items {
    private String itemName;
    private String itemOption;
    private String itemQuantity;
    private String itemAmount;

    public Items() {
    }

    public Items(String itemName, String itemOption, String itemQuantity, String itemAmount) {
        this.itemName = itemName;
        this.itemOption = itemOption;
        this.itemQuantity = itemQuantity;
        this.itemAmount = itemAmount;
    }

    public Items(String itemName, String itemOption, String itemQuantity) {
        this.itemName = itemName;
        this.itemOption = itemOption;
        this.itemQuantity = itemQuantity;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemOption() {
        return itemOption;
    }

    public void setItemOption(String itemOption) {
        this.itemOption = itemOption;
    }

    public String getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(String itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public String getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(String itemAmount) {
        this.itemAmount = itemAmount;
    }
}
