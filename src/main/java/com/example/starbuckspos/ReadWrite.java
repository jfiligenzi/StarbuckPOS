package com.example.starbuckspos;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ReadWrite {
    public static void openFile(ArrayList<Drink> drinks, String fileName) throws IOException {
        String result = "";
        String size[] = new String[0];
        String cost[] = new String[0];
        String[] components;
        File fileObj = new File (fileName);
        if(fileObj.exists()) {
            Scanner fileIn = new Scanner(fileObj);
            if(fileIn.hasNext()) {
                drinks.clear();
            }
            while(fileIn.hasNext()) {
                result = fileIn.nextLine();
                components = result.split("\t");

                    /*
                     *  Add Coffee based drinks
                     */
                if(components[0].equalsIgnoreCase("coffee")) {

                    //Array handling
                    if(components[2] != null) {
                        components[2] = components[2].replace("\"", "");
                        for(int i = 0; i < 3; i++) {
                            size = components[2].split(",");
                        }
                    }

                    //Array handling
                    if(components[3] != null) {
                        components[3] = components[3].replace("\"", "");
                        for(int i = 0; i < 3; i++) {
                            cost = components[3].split(",");
                        }
                    }

                    drinks.add(new Coffee(components[0], components[1], size, cost, components[4]));

                    /*
                     * Add Tea based drinks
                     */
                } else if (components[0].equalsIgnoreCase("tea")) {
                    //Array handling
                    if(components[2] != null) {
                        components[2] = components[2].replace("\"", "");
                        for(int i = 0; i < 4; i++) {
                            size = components[2].split(",");
                        }
                    }

                    //Array handling
                    if(components[3] != null) {
                        components[3] = components[3].replace("\"", "");
                        for(int i = 0; i < 4; i++) {
                            cost = components[3].split(",");
                        }
                    }

                    drinks.add(new Tea(components[0], components[1], size, cost, components[4], components[5]));

                    /*
                     * Add Beverage based drinks
                     */
                } else if (components[0].equalsIgnoreCase("beverage")) {

                    //Array handling
                    if(components[2] != null) {
                        components[2] = components[2].replace("\"", "");
                        for(int i = 0; i < 3; i++) {
                            size = components[2].split(",");
                        }
                    }

                    //Array handling
                    if(components[3] != null) {
                        components[3] = components[3].replace("\"", "");
                        for(int i = 0; i < 3; i++) {
                            cost = components[3].split(",");
                        }
                    }

                    drinks.add(new Beverage(components[0], components[1], size, cost, Integer.parseInt(components[4]), components[5], components[6], Boolean.parseBoolean(components[7])));

                    /*
                     * Add Frappucino based drinks
                     */
                } else if (components[0].equalsIgnoreCase("frappucino")) {

                    //Array handling
                    if(components[2] != null) {
                        components[2] = components[2].replace("\"", "");
                        for(int i = 0; i < 3; i++) {
                            size = components[2].split(",");
                        }
                    }

                    //Array handling
                    if(components[3] != null) {
                        components[3] = components[3].replace("\"", "");
                        for(int i = 0; i < 3; i++) {
                            cost = components[3].split(",");
                        }
                    }

                    drinks.add(new Frappucino(components[0], components[1], size, cost, components[4], Boolean.parseBoolean(components[5]), components[6]));

                }

            }
            fileIn.close();

        } else {
            System.out.println("Error, File not found");
        }
    }

    public static void saveFile(ArrayList<Drink> drinks, String fileName) throws IOException {
        File fileObj = new File(fileName);
        PrintWriter fileOut = new PrintWriter(fileObj);
        for (Drink dri:drinks) {
            if(dri.getClass()==Coffee.class) {
                fileOut.println(dri.getDrinkType() + "\t" + dri.getDrinkName() + "\t" + Arrays.toString(dri.getDrinkSize()).replace("[", "").replace("]", "").replace(" ", "")
                        + "\t" + Arrays.toString(dri.getDrinkPrice()).replace("[", "").replace("]", "").replace(" ", "") + "\t" + ((Coffee) dri).getBrewType());
            }

            if(dri.getClass()==Tea.class) {
                fileOut.println(dri.getDrinkType() + "\t" + dri.getDrinkName() + "\t" + Arrays.toString(dri.getDrinkSize()).replace("[", "").replace("]", "").replace(" ", "")
                        + "\t" + Arrays.toString(dri.getDrinkPrice()).replace("[", "").replace("]", "").replace(" ", "") + "\t" + ((Tea) dri).getTeaBase() + "\t" + ((Tea) dri).getTeaAddition());
            }

            if(dri.getClass()==Beverage.class) {
                fileOut.println(dri.getDrinkType() + "\t" + dri.getDrinkName() + "\t" + Arrays.toString(dri.getDrinkSize()).replace("[", "").replace("]", "").replace(" ", "")
                        + "\t" + Arrays.toString(dri.getDrinkPrice()).replace("[", "").replace("]", "").replace(" ", "") + "\t" + ((Beverage) dri).getShots() + "\t" + ((Beverage) dri).getDrinkLiquid()
                        + "\t" + ((Beverage) dri).getDrinkToppings() + "\t" + ((Beverage) dri).isDrinkIced());
            }

            if(dri.getClass()==Frappucino.class) {
                fileOut.println(dri.getDrinkType() + "\t" + dri.getDrinkName() + "\t" + Arrays.toString(dri.getDrinkSize()).replace("[", "").replace("]", "").replace(" ", "")
                        + "\t" + Arrays.toString(dri.getDrinkPrice()).replace("[", "").replace("]", "").replace(" ", "") + "\t" + ((Frappucino) dri).getDrinkLiquid() + "\t" +
                        ((Frappucino) dri).isCremeBase() + "\t" + ((Frappucino) dri).getDrinkToppings());
            }
        }
        fileOut.close();
    }

    public static void sort(ArrayList<Drink> drinks) {
        sort(drinks, 0, drinks.size() - 1);
    }

    public static void sort(ArrayList<Drink> drinks, int low, int high) {
        if (low < high) {
            int indexOfMin = low; //Sets indexOfMin to the low value 0
            double min = (double) drinks.get(low).getDrinkType().charAt(0); //Sets the min value to the value of the first character of the name of the location 86
            Drink drinksHold = drinks.get(low);
            for (int i = low + 1; i <= high; i++) { //Does as long as i <= the high value, and i is one higher than above i = 0 + 1; i <= 8; i++
                if (drinks.get(i).getDrinkType().charAt(0) < min) { //If the value of the first character of the name of the location is lower than the min above 120 < 86
                    min = drinks.get(i).getDrinkType().charAt(0); //Min is now set to the new value of the character
                    drinksHold = drinks.get(i);
                    indexOfMin = i; //indexOfMin is now set to i
                }
            }

            drinks.set(indexOfMin, drinks.get(low));
            drinks.set(low, drinksHold);

            sort(drinks, low + 1, high);
        }
    }
}

