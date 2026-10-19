package com.datapars.fabula;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class PrimaryController {

    @FXML
    private Button btnIniciar;
    @FXML
    private Label lblLiebre;
    @FXML
    private ProgressBar pbLiebre;
    @FXML
    private Label lblTortuga;
    @FXML
    private ProgressBar pbTortuga;

    private volatile boolean carreraTerminada = false;

    @FXML
    public void iniciarCarrera() {
        btnIniciar.setDisable(true); 
        carreraTerminada = false;
        pbLiebre.setProgress(0);
        pbTortuga.setProgress(0);
        lblLiebre.setText("La Liebre: Está corriendo");
        lblTortuga.setText("La Tortuga: Está corriendo");

        Thread hiloLiebre = new Thread(() -> {
            double progreso = 0.0;
            try {
                while (progreso < 1.0 && !carreraTerminada) {
                    Thread.sleep(200); 
                    progreso += 0.05; 

                    if (progreso >= 0.5 && progreso < 0.55) {
                        Platform.runLater(() -> lblLiebre.setText("La Liebre: Se durmio"));
                        Thread.sleep(6200); 
                        Platform.runLater(() -> lblLiebre.setText("La Liebre: Se desperto"));
                    }

                    if (progreso > 1.0) progreso = 1.0;
                    final double p = progreso;
                    
                    Platform.runLater(() -> pbLiebre.setProgress(p));
                }

                if (progreso >= 1.0 && !carreraTerminada) {
                    carreraTerminada = true;
                    Platform.runLater(() -> {
                        lblLiebre.setText("La Liebre gana");
                        btnIniciar.setDisable(false);
                    });
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        Thread hiloTortuga = new Thread(() -> {
            double progreso = 0.0;
            try {
                while (progreso < 1.0 && !carreraTerminada) {
                    Thread.sleep(200); 
                    progreso += 0.02; 

                    if (progreso > 1.0) progreso = 1.0;
                    final double p = progreso;
                    

                    Platform.runLater(() -> pbTortuga.setProgress(p));
                }

                if (progreso >= 1.0 && !carreraTerminada) {
                    carreraTerminada = true;
                    Platform.runLater(() -> {
                        lblTortuga.setText("La Tortuga gana");
                        if(pbLiebre.getProgress() < 1.0) {
                             lblLiebre.setText("La Liebre pierde...");
                        }
                        btnIniciar.setDisable(false);
                    });
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        hiloLiebre.start();
        hiloTortuga.start();
    }
}