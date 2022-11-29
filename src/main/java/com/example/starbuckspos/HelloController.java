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
import java.util.Hashtable;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    //Creates drink array list
    ArrayList<Drink> drinks = new ArrayList<Drink>();
    //Creates drink queue
    java.util.Queue<Drink> drinkQueue = new java.util.LinkedList<>();
    //Creates map for customer names
    Hashtable<String, Integer> customerName = new Hashtable<>();
    //Creates order number
    binarySearchTree<Transaction> transactionList = new binarySearchTree<>();

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
    private TextField customerNameField;

    @FXML
    private Label currentOrders;

    @FXML
    private Button finishOrder;

    @FXML
    private Button showOrder;

    @FXML
    private Button debugButton;

    @FXML
    void debugButtonClicked(ActionEvent event) {
        transactionList.inorder();
        System.out.println("\n-=BREAK=-\n");
        transactionList.preorder();
        System.out.println("\n-=BREAK=-\n");
        transactionList.postorder();
        System.out.println("\n-=BREAK=-\n");
        System.out.println("BST size: " + transactionList.getSize());
        System.out.println("\n-=BREAK=-\n");
        System.out.println("Size of Hashtable: " + customerName.size());
        System.out.println("Hashtable:\n" + customerName);


    }

    @FXML
    void showOrdersButton(ActionEvent event) {
        String text = "";
        currentOrders.setText(text);
    }

    @FXML
    private TextField searchOrdersText;

    //On enter button press will update customer name map
    @FXML
    void searchCustomerName(ActionEvent event) {

    }

    @FXML
    void finishOrderButton(ActionEvent event) {
        //Adds current drinks in order to a transaction and then adds the transaction to a transaction BST
        ArrayList<Drink> currentDrinks = new ArrayList<Drink>();
        Transaction transaction = new Transaction();
        while(drinkQueue.size() > 0) {
            currentDrinks.add(drinkQueue.remove());
        }
        transaction.setCustomerName(customerNameField.getText());
        transaction.setDrinks(currentDrinks);
        transactionList.insert(transaction);


        //Creates a hash map for the customer name and order number
        Hash orderNumber = new Hash(customerNameField.getText());
        customerName.put(customerNameField.getText(), orderNumber.hashValue);
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

        finalLabel.setText(currentDrink.toString());

    }

    private String[] coffees;

    //Choice Box in case extra drinks are added
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<Drink> drinks = new ArrayList<Drink>();
        try {
            ReadWrite.openFile(drinks, "drinks.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(int i = 0; i < drinks.size(); i++) {
            extraDrinkChoice.getItems().add(drinks.get(i).getDrinkName());
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

    class Hash {
        final int p = 31;
        final int m = 1000000007;
        int hashValue;
        Hash(String string) {
            int currentHash = 0;
            final char[] s = string.toCharArray();
            long power = 1;
            final int n = string.length();
            for(int i = 0; i < n; i++) {
                currentHash = (int)((currentHash + (s[i] - 'a' + 1) * power) % m);
                power = (power * p) % m;
            }
            hashValue = currentHash;
        }
    }
}
