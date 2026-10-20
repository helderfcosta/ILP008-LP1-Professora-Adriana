module org.example {
    requires javafx.controls;
    requires javafx.fxml;

    // O JavaFX precisa "enxergar" os Controllers para ligar os botões e campos do FXML
    opens org.example.controller to javafx.fxml;
    exports org.example;
}
