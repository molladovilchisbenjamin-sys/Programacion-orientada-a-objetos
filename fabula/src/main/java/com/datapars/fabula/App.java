package com.datapars.fabula;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/com/datapars/fabula/primary.fxml"));
        Parent root = fxmlLoader.load();
        
        Scene scene = new Scene(root, 400, 450);
        
        stage.setTitle("Liebre vs Tortuga");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}