module com.example.samochod {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.samochod to javafx.fxml;
    exports com.example.samochod;
}