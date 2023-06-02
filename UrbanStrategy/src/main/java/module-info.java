module com.example.urbanstrategy {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.urbanstrategy to javafx.fxml;
    exports com.example.urbanstrategy;
}