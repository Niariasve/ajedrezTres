module ec.edu.espol.ajedreztres {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens ec.edu.espol.ajedreztres to javafx.fxml;
    exports ec.edu.espol.ajedreztres;
    
    opens ec.edu.espol.controllers to javafx.fxml;
    exports ec.edu.espol.controllers;
}
