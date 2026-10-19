package com.datapars.conteo;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML
    private TextField txtConteo;
    @FXML
    private Button btnEsperar;
    @FXML
    private ProgressBar progressBar;
    private int contadorClics = 0;

    
    @FXML
    public void initialize() {
        txtConteo.setText("0");
    }

    @FXML
    public void contarClic() {
        contadorClics++;
        txtConteo.setText(String.valueOf(contadorClics));
    }

    @FXML
    public void iniciarEspera() {
        btnEsperar.setDisable(true);
        
        progressBar.setProgress(0);

        Thread hiloEspera = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    Thread.sleep(1000);
                    
                    double progreso = i / 10.0;
                    
                    Platform.runLater(() -> {
                        progressBar.setProgress(progreso);
                    });
                }

                
                Platform.runLater(() -> {
                    btnEsperar.setDisable(false);
                });

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        hiloEspera.start();
    }
}