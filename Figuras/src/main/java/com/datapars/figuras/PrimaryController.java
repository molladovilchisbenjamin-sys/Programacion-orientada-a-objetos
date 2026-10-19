package com.datapars.figuras;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class PrimaryController {

    @FXML
    private TextArea txtSalida;

    @FXML
    private void handleEjecutar(ActionEvent event) {
        StringBuilder sb = new StringBuilder();

        Figura2D f = new TrianguloRect(3, 4);
        sb.append(f.imprimeFigura()).append("\n\n");

        f = new Circulo(3);
        sb.append(f.imprimeFigura()).append("\n");

        txtSalida.setText(sb.toString());
    }
}