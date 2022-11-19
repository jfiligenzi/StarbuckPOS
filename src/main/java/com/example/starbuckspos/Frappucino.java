package com.example.starbuckspos;

import java.util.Arrays;

public class Frappucino extends Drink{
    private String drinkLiquid;
    private boolean isCremeBase;
    private String drinkToppings;

    public Frappucino(String drinkType, String drinkName, String[] drinkSize, String[] drinkPrice, String drinkLiquid, boolean isCremeBase, String drinkToppings) {
        super(drinkType, drinkName, drinkSize, drinkPrice);
        this.drinkLiquid = drinkLiquid;
        this.isCremeBase = isCremeBase;
        this.drinkToppings = drinkToppings;
    }

    public String getDrinkLiquid() {
        return drinkLiquid;
    }

    public void setDrinkLiquid(String drinkLiquid) {
        this.drinkLiquid = drinkLiquid;
    }

    public boolean isCremeBase() {
        return isCremeBase;
    }

    public void setCremeBase(boolean cremeBase) {
        isCremeBase = cremeBase;
    }

    public String getDrinkToppings() {
        return drinkToppings;
    }

    public void setDrinkToppings(String drinkToppings) {
        this.drinkToppings = drinkToppings;
    }

    @Override
    public String toString() {
        return "Frappucino{" +
                "drinkName='" + drinkName + '\'' +
                ", drinkSize=" + Arrays.toString(drinkSize) +
                ", drinkPrice=" + Arrays.toString(drinkPrice) +
                ", drinkLiquid='" + drinkLiquid + '\'' +
                ", isCremeBase=" + isCremeBase +
                ", drinkToppings='" + drinkToppings + '\'' +
                '}';
    }
}
