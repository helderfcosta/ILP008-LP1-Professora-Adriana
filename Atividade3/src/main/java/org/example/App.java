package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Classe que inicia o programa: abre a janela principal (main.fxml),
 * que contém uma aba para cada classe Model.
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("view/main.fxml"));
        Scene scene = new Scene(loader.load(), 900, 660);
        stage.setTitle("Atividade 3 - Interface Gráfica (JavaFX)");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
