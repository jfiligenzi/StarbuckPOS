package com.example.starbuckspos;

import java.util.Arrays;

public class Beverage extends Drink{
    private int shots;
    private String drinkLiquid;
    private String drinkToppings;
    private boolean isDrinkIced;

    public Beverage(String drinkType, String drinkName, String[] drinkSize, String[] drinkPrice, int shots, String drinkLiquid, String drinkToppings, boolean isDrinkIced) {
        super(drinkType, drinkName, drinkSize, drinkPrice);
        this.shots = shots;
        this.drinkLiquid = drinkLiquid;
        this.drinkToppings = drinkToppings;
        this.isDrinkIced = isDrinkIced;
    }

    public int getShots() {
        return shots;
    }

    public void setShots(int shots) {
        this.shots = shots;
    }

    public String getDrinkLiquid() {
        return drinkLiquid;
    }

    public void setDrinkLiquid(String drinkLiquid) {
        this.drinkLiquid = drinkLiquid;
    }

    public String getDrinkToppings() {
        return drinkToppings;
    }

    public void setDrinkToppings(String drinkToppings) {
        this.drinkToppings = drinkToppings;
    }

    public boolean isDrinkIced() {
        return isDrinkIced;
    }

    public void setDrinkIced(boolean drinkIced) {
        isDrinkIced = drinkIced;
    }

    @Override
    public String toString() {
        return drinkName + "\nSizes: " + Arrays.toString(drinkSize) +
                "\nPrices: " + Arrays.toString(drinkPrice) +
                "\nEspresso shots: " + shots +
                "\nLiquid type: " + drinkLiquid +
                "\nIced?: " + isDrinkIced +
                "\nDrink Toppings: " + drinkToppings;
    }
}
