package com.example.starbuckspos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/*
Current application is in beta as it features to meet requirements but not all are implemented through the GUI
- GUI currently allows for 'orders' to be made where you can submit names and hit the buttons to add drinks to the orders
- Read/Write, and Sort features are available through main
- Sorting is done by recursion as nothing else aside from the drinks.txt needs to be sorted for now
- A queue handles the current drinks in the order, while a map handles the order number and name (to be linked with transaction later)
- Commented out text below allows to test write/sort features
 */

public class HelloApplication extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setTitle("StarbucksPOS ver1.0");
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


