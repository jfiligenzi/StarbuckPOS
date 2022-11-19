package com.example.starbuckspos;

import java.util.Arrays;

public class Coffee extends Drink{
    private String brewType;

    public Coffee(String drinkType, String drinkName, String[] drinkSize, String[] drinkPrice, String brewType) {
        super(drinkType, drinkName, drinkSize, drinkPrice);
        this.brewType = brewType;
    }

    public String getBrewType() {
        return brewType;
    }

    public void setBrewType(String brewType) {
        this.brewType = brewType;
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "brewType='" + brewType + '\'' +
                ", drinkType='" + drinkType + '\'' +
                ", drinkName='" + drinkName + '\'' +
                ", drinkSize=" + Arrays.toString(drinkSize) +
                ", drinkPrice=" + Arrays.toString(drinkPrice) +
                '}';
    }
}
