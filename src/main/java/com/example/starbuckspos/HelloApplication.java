package com.example.starbuckspos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/*
Current application is in beta as it features to meet requirements but not all are implemented through the GUI
- Name changed to SpaceBux to avoid copyright
- Read/Write, and Sort features are available through main or editing the file itself
- inorder traversal searching using recursion allowing for you to find orders based on the customers name <--- improvement of my choice
- A queue handles the current drinks in the order with a hashtable checking to see if a last name is needed
- Networking enabled printing feature that will print a list of drinks right to your printer!
- A fancy BST that stores all the transactions
- Other general features include ArrayList data structures, linked lists, color coded GUI
- debug button is used for printing to console
 */

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setTitle("SpaceBux ver1.4");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws IOException {
        launch();

//        binarySearchTree<String> tree = new binarySearchTree<>();
//        tree.insert();
//        ReadWrite.openFile(drinks, "drinks.txt");
//        java.util.Queue<Drink> drinkQueue = new java.util.LinkedList<>();
//        System.out.println(drinks.toString());
//        drinkQueue.offer(drinks.get(1));
//        for(int i = 0; i < 4; i++) {
//            drinkQueue.offer(drinks.get(i));
//        }
//        while(drinkQueue.size() > 0) {
//            System.out.println(drinkQueue.remove().getDrinkName() + " ");
//        }
//        ReadWrite.openFile(drinks, "drinks.txt");
//        ReadWrite.sort(drinks);
//        System.out.println(drinks.get(2).toString());
//        System.out.println(drinks.get(6).toString());
//        System.out.println(drinks.get(0).toString());
//        System.out.println(drinks.get(4).toString());
//        System.out.println(drinks.get(5).toString());
//        drinks.add(new Coffee("coffee", "out of place", new String[]{"tall","grande","venti"}, new String[]{"1","2","3"}, "medium"));
//        drinks.add(new Tea("tea", "Passion Tea", new String[]{"tall","grande","venti","trenta"}, new String[]{"1","2","3","4"}, "Passion", "Water"));
//        drinks.add(new Beverage("beverage", "Cafe Latte", new String[]{"tall","grande","venti"}, new String[]{"1","2","3"}, 2, "2%", "None", false));
//        drinks.add(new Frappucino("frappucino", "Caramel Frappucino", new String[]{"tall","grande","venti"}, new String[]{"1","2","3"}, "Whole", false, "Whipped Cream + Caramel Drizzle"));
//        System.out.println(drinks.get(6).toString());
//        ReadWrite.saveFile(drinks, "drinks.txt");
    }
}


