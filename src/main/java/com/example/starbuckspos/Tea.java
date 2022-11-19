package com.example.starbuckspos;

import java.util.Arrays;

public class Tea extends Drink{
    private String teaBase;
    private String teaAddition;

    public Tea(String drinkType, String drinkName, String[] drinkSize, String[] drinkPrice, String teaBase, String teaAddition) {
        super(drinkType, drinkName, drinkSize, drinkPrice);
        this.teaBase = teaBase;
        this.teaAddition = teaAddition;
    }

    public String getTeaBase() {
        return teaBase;
    }

    public void setTeaBase(String teaBase) {
        this.teaBase = teaBase;
    }

    public String getTeaAddition() {
        return teaAddition;
    }

    public void setTeaAddition(String teaAddition) {
        this.teaAddition = teaAddition;
    }

    @Override
    public String toString() {
        return "Tea{" +
                "drinkName='" + drinkName + '\'' +
                ", drinkSize=" + Arrays.toString(drinkSize) +
                ", drinkPrice=" + Arrays.toString(drinkPrice) +
                ", teaBase='" + teaBase + '\'' +
                ", teaAddition='" + teaAddition + '\'' +
                '}';
    }
}
