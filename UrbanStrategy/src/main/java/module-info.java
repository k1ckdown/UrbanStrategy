module com.example.urbanstrategy {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.urbanstrategy to javafx.fxml;
    exports com.example.urbanstrategy;
    exports com.example.urbanstrategy.UI;
    opens com.example.urbanstrategy.UI to javafx.fxml;
}