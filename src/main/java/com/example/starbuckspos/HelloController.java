package com.example.starbuckspos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Label finalLabel;

    @FXML
    private ChoiceBox<String> coffeeChoice;

    @FXML
    private ChoiceBox<String> teaChoice;

    @FXML
    private ChoiceBox<String> beverageChoice;

    @FXML
    private ChoiceBox<String> frappucinoChoice;




    private String[] coffees;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ArrayList<Drink> drinks = new ArrayList<Drink>();

        try {
            ReadWrite.openFile(drinks, "drinks.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(int i = 0; i < drinks.size(); i ++) {
            if(drinks.get(i).getClass() == Coffee.class) {
                coffeeChoice.getItems().add(drinks.get(i).drinkName);

            }

            if(drinks.get(i).getClass() == Tea.class) {
                teaChoice.getItems().add(drinks.get(i).drinkName);
            }

            if(drinks.get(i).getClass() == Beverage.class) {
                beverageChoice.getItems().add(drinks.get(i).drinkName);
            }

            if(drinks.get(i).getClass() == Frappucino.class) {
                frappucinoChoice.getItems().add(drinks.get(i).drinkName);
            }

        }

//        coffee = new String[]{drinks.get(0).getDrinkName(), drinks.get(1).getDrinkName()};


//        coffeeChoice.getItems().addAll(coffees);

        coffeeChoice.setOnAction(this::getCoffee);
        teaChoice.setOnAction(this::getTea);
        beverageChoice.setOnAction(this::getBeverage);
        frappucinoChoice.setOnAction(this::getFrappucino);
    }

    public void getCoffee(ActionEvent event) {
        ArrayList<Drink> drinks = new ArrayList<Drink>();

        try {
            ReadWrite.openFile(drinks, "drinks.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        String myDrink = coffeeChoice.getValue();
        int count = 0;
        while(true) {
            if(myDrink.equalsIgnoreCase(drinks.get(count).getDrinkName())) {
                finalLabel.setText(drinks.get(count).toString());
                break;
            }
            count++;
        }
    }

    public void getTea(ActionEvent event) {
        ArrayList<Drink> drinks = new ArrayList<Drink>();

        try {
            ReadWrite.openFile(drinks, "drinks.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        String myDrink = teaChoice.getValue();
        int count = 0;
        while(true) {
            if(myDrink.equalsIgnoreCase(drinks.get(count).getDrinkName())) {
                finalLabel.setText(drinks.get(count).toString());
                break;
            }
            count++;
        }
    }

    public void getBeverage(ActionEvent event) {
        ArrayList<Drink> drinks = new ArrayList<Drink>();

        try {
            ReadWrite.openFile(drinks, "drinks.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        String myDrink = beverageChoice.getValue();
        int count = 0;
        while(true) {
            if(myDrink.equalsIgnoreCase(drinks.get(count).getDrinkName())) {
                finalLabel.setText(drinks.get(count).toString());
                break;
            }
            count++;
        }
    }

    public void getFrappucino(ActionEvent event) {
        ArrayList<Drink> drinks = new ArrayList<Drink>();

        try {
            ReadWrite.openFile(drinks, "drinks.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        String myDrink = frappucinoChoice.getValue();
        int count = 0;
        while(true) {
            if(myDrink.equalsIgnoreCase(drinks.get(count).getDrinkName())) {
                finalLabel.setText(drinks.get(count).toString());
                break;
            }
            count++;
        }
    }
}