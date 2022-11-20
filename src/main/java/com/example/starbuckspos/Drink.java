package com.example.starbuckspos;

import java.util.Arrays;

public class Drink {
    protected String drinkType;
    protected String drinkName;
    protected String[] drinkSize;
    protected String[] drinkPrice;


    public Drink(String drinkType, String drinkName, String[] drinkSize, String[] drinkPrice) {
        this.drinkType = drinkType;
        this.drinkName = drinkName;
        this.drinkPrice = drinkPrice;
        this.drinkSize = drinkSize;
    }

    public Drink() {

    }

    public String getDrinkType() {
        return drinkType;
    }

    public void setDrinkType(String drinkType) {
        this.drinkType = drinkType;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public String[] getDrinkPrice() {
        return drinkPrice;
    }

    public void setDrinkPrice(String[] drinkPrice) {
        this.drinkPrice = drinkPrice;
    }

    public String[] getDrinkSize() {
        return drinkSize;
    }

    public void setDrinkSize(String[] drinkSize) {
        this.drinkSize = drinkSize;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "drinkName='" + drinkName + '\'' +
                ", drinkPrice='" + Arrays.toString(drinkPrice) +
                ", drinkSize='" + Arrays.toString(drinkSize) + '\'' +
                '}';
    }
}
