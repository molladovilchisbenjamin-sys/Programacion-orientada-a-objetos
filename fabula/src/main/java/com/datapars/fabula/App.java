package com.datapars.fabula;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    @Override
    public void start(Stage ventana) throws IOException {
        FXMLLoader cargador = new FXMLLoader(App.class.getResource("/com/datapars/fabula/primary.fxml"));
        Parent raiz = cargador.load();

        Scene escena = new Scene(raiz, 400, 450);

        ventana.setTitle("Liebre vs Tortuga");
        ventana.setScene(escena);
        ventana.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
