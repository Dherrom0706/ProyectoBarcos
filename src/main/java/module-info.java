module com.example.proyectobatalladelmarcoral {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.proyectobatalladelmarcoral to javafx.fxml;
    exports com.example.proyectobatalladelmarcoral;
}