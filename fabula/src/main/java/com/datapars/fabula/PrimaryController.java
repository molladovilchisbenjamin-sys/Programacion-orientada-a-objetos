package com.datapars.fabula;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class PrimaryController {

    @FXML
    private Button btnEmpezar;
    @FXML
    private Label etiLiebre;
    @FXML
    private ProgressBar barraLiebre;
    @FXML
    private Label etiTortuga;
    @FXML
    private ProgressBar barraTortuga;

    private volatile boolean finalizada = false;

    @FXML
    public void comenzarCarrera() {
        btnEmpezar.setDisable(true);
        finalizada = false;
        barraLiebre.setProgress(0);
        barraTortuga.setProgress(0);
        etiLiebre.setText("La Liebre: Está corriendo");
        etiTortuga.setText("La Tortuga: Está corriendo");

        Thread corredorLiebre = new Thread(() -> {
            double avance = 0.0;
            try {
                while (avance < 1.0 && !finalizada) {
                    Thread.sleep(200);
                    avance = Math.min(avance + 0.05, 1.0);

                    if (avance >= 0.5 && avance < 0.55) {
                        Platform.runLater(() -> etiLiebre.setText("La Liebre: Se durmio"));
                        Thread.sleep(6200);
                        Platform.runLater(() -> etiLiebre.setText("La Liebre: Se desperto"));
                    }

                    final double v = avance;
                    Platform.runLater(() -> barraLiebre.setProgress(v));
                }

                if (avance >= 1.0 && !finalizada) {
                    finalizada = true;
                    Platform.runLater(() -> {
                        etiLiebre.setText("La Liebre gana");
                        btnEmpezar.setDisable(false);
                    });
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread corredorTortuga = new Thread(() -> {
            double avance = 0.0;
            try {
                while (avance < 1.0 && !finalizada) {
                    Thread.sleep(200);
                    avance = Math.min(avance + 0.02, 1.0);

                    final double v = avance;
                    Platform.runLater(() -> barraTortuga.setProgress(v));
                }

                if (avance >= 1.0 && !finalizada) {
                    finalizada = true;
                    Platform.runLater(() -> {
                        etiTortuga.setText("La Tortuga gana");
                        if (barraLiebre.getProgress() < 1.0) {
                            etiLiebre.setText("La Liebre pierde...");
                        }
                        btnEmpezar.setDisable(false);
                    });
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        corredorLiebre.start();
        corredorTortuga.start();
    }
}
