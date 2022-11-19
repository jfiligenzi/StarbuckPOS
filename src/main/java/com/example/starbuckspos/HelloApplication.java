package com.example.starbuckspos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

/*
Current application is in beta as it features to meet requirements but not all are implemented through the GUI
- GUI currently can select and show drink recipes
- Read/Write, and Sort features are available through main
- Using recursion to sort as it fits my needs best for sorting alphabetically as I'm just comparing and sorting by drink type for data and there isn't much data



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

    private static ArrayList<Drink> drinks = new ArrayList<Drink>();

    public static void main(String[] args) throws IOException {
        launch();
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