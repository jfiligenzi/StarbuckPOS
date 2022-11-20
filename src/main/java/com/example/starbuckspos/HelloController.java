package com.example.starbuckspos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

public class HelloController implements Initializable {
    //Creates drink array list
    ArrayList<Drink> drinks = new ArrayList<Drink>();
    //Creates drink queue
    java.util.Queue<Drink> drinkQueue = new java.util.LinkedList<>();
    //Creates map for customer names
    Map<Integer, String> customerName = new TreeMap<>();
    //Creates order number
    int orderNumber = 0;


    //Initializes all the buttons,labels, and stuff
    @FXML
    private Label finalLabel;

    @FXML
    private Button blondeButton;

    @FXML
    private Button caramelAppleButton;

    @FXML
    private Button caramelFrapButton;

    @FXML
    private Button caramelMachButton;

    @FXML
    private Button darkButton;

    @FXML
    private Button espressoButton;

    @FXML
    private Button flatWhiteButton;

    @FXML
    private ChoiceBox<String> extraDrinkChoice;

    @FXML
    private Button hotChocolateButton;

    @FXML
    private Button latteButton;

    @FXML
    private Button matchaFrapButton;

    @FXML
    private Button mochaButton;

    @FXML
    private Button mochaFrapButton;

    @FXML
    private Button pikeButton;

    @FXML
    private Button pourButton;

    @FXML
    private Button vanillaBeanFrapButton;

    @FXML
    private Button whiteMochaButton;

    @FXML
    private Button passionTeaButton;

    @FXML
    private Button blackTeaButton;

    @FXML
    private Button greenTeaButton;

    @FXML
    private Button customTeaButton;

    @FXML
    private Button printQueueButton;

    @FXML
    private TextField customerNameField;

    @FXML
    private Label currentOrders;

    //On enter button press will update customer name map
    @FXML
    void updateCustomerName(ActionEvent event) {
        System.out.println("test");
        customerName.put(orderNumber, customerNameField.getText());
        currentOrders.setText(customerName.toString());
        orderNumber = orderNumber + 1;
    }

    //Prints the drink queue
    @FXML
    void printButtonClicked(ActionEvent event) {
        String printString = "";
        while(drinkQueue.size() > 0) {
            printString += drinkQueue.remove().toString() + "\n\n";
        }
        finalLabel.setText("Customer Name: " + customerName.get(orderNumber - 1) + "\nCurrent Order:\n" + printString);
    }



    //Buttons for every drink
    @FXML
    void buttonClicked(ActionEvent event) throws IOException {
        ReadWrite.openFile(drinks, "drinks.txt");
        Drink currentDrink = new Drink();

        //First Drink Column
        if(event.getSource() == pikeButton) {
            currentDrink = findDrink("Pike Place", drinks);
            drinkQueue.offer(currentDrink);
        }
        else if(event.getSource() == darkButton) {
            currentDrink = findDrink("Dark Roast", drinks);
            drinkQueue.offer(currentDrink);
        }
        else if(event.getSource() == blondeButton) {
            currentDrink = findDrink("Blonde Roast", drinks);
            drinkQueue.offer(currentDrink);
        }
        else if(event.getSource() == pourButton) {
            currentDrink = findDrink("Pour Over", drinks);
            drinkQueue.offer(currentDrink);
        }
        //Second Drink Column
        else if(event.getSource() == latteButton) {
            currentDrink = findDrink("Latte", drinks);
            drinkQueue.offer(currentDrink);
        }
        else if(event.getSource() == mochaButton) {
            currentDrink = findDrink("Mocha", drinks);
            drinkQueue.offer(currentDrink);
        }
        else if(event.getSource() == whiteMochaButton) {
            currentDrink = findDrink("White Mocha", drinks);
            drinkQueue.offer(currentDrink);
        }
        else if(event.getSource() == caramelMachButton) {
            currentDrink = findDrink("Caramel Macchiato", drinks);
            drinkQueue.offer(currentDrink);
        }
        //Third Drink Column
        else if(event.getSource() == espressoButton) {
            currentDrink = findDrink("Espresso Shots", drinks);
            drinkQueue.offer(currentDrink);
        }
        else if(event.getSource() == flatWhiteButton) {
            currentDrink = findDrink("Flat White", drinks);
            drinkQueue.offer(currentDrink);
        }
        else if(event.getSource() == hotChocolateButton) {
            currentDrink = findDrink("Hot Chocolate", drinks);
            drinkQueue.offer(currentDrink);
        }
        else if(event.getSource() == caramelAppleButton) {
            currentDrink = findDrink("Caramel Apple Spice", drinks);
            drinkQueue.offer(currentDrink);
        }
        //Fourth Drink Column
        else if(event.getSource() == caramelFrapButton) {
            currentDrink = findDrink("Caramel Frappucino", drinks);
            drinkQueue.offer(currentDrink);
        }
        else if(event.getSource() == mochaFrapButton) {
            currentDrink = findDrink("Mocha Frappucino", drinks);
            drinkQueue.offer(currentDrink);
        }
        else if(event.getSource() == vanillaBeanFrapButton) {
            currentDrink = findDrink("Vanilla Bean Frappucino", drinks);
            drinkQueue.offer(currentDrink);
        }
        else if(event.getSource() == matchaFrapButton) {
            currentDrink = findDrink("Matcha Frappucino", drinks);
            drinkQueue.offer(currentDrink);
        }
        //Fifth Drink Column
        else if(event.getSource() == passionTeaButton) {
            currentDrink = findDrink("Passion Tea", drinks);
            drinkQueue.offer(currentDrink);
        }
        else if(event.getSource() == blackTeaButton) {
            currentDrink = findDrink("Black Tea", drinks);
            drinkQueue.offer(currentDrink);
        }
        else if(event.getSource() == greenTeaButton) {
            currentDrink = findDrink("Green Tea", drinks);
            drinkQueue.offer(currentDrink);
        }
        else if(event.getSource() == customTeaButton) {
            currentDrink = findDrink("Hot Tea", drinks);
            drinkQueue.offer(currentDrink);
        }

    }

    private String[] coffees;

    //currently unneeded
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<Drink> drinks = new ArrayList<Drink>();
        try {
            ReadWrite.openFile(drinks, "drinks.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //Method to find the drink in the arraylist
    public Drink findDrink(String name, ArrayList<Drink> drinks) {
        for(Drink drink : drinks) {
            if(drink.getDrinkName().equalsIgnoreCase(name)) {
                return drink;
            }
        }
        return null;
    }
}
