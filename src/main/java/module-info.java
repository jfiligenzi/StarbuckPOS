module com.example.starbuckspos {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.starbuckspos to javafx.fxml;
    exports com.example.starbuckspos;
}