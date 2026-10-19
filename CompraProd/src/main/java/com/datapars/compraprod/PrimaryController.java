package com.datapars.compraprod;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PrimaryController implements Initializable {
    
    @FXML private TextArea txtProductos;
    @FXML private TextArea txtOrdenSelec;
    @FXML private TextField TFOrden;
    

    private Productos hamburguesa;
    private Productos cheetos;
    private Productos mazapan;
    private Productos cocacola;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        hamburguesa = new Productos(1, "Hamburguesa", 99.9);
        cheetos = new Productos(2, "cheetos", 10.9);
        mazapan = new Productos(3, "mazapan", 6.9);
        cocacola = new Productos(4, "cocacola", 24.9);
        
        txtProductos.setText(hamburguesa + "\n" + cheetos + "\n" + mazapan + "\n" + cocacola);
    }
    
    @FXML
    private void SeleccionarProd() throws IOException {
        try {

            int opcion = Integer.parseInt(TFOrden.getText());
            
            if (opcion == 1) {
                txtOrdenSelec.setText("Pediste: " + hamburguesa.getProducto() + " Precio: " + hamburguesa.getPrecio());
            } else if (opcion == 2) {
                txtOrdenSelec.setText("Pediste: " + cheetos.getProducto() + " Precio: " + cheetos.getPrecio());
            } else if (opcion == 3) {
                txtOrdenSelec.setText("Pediste: " + mazapan.getProducto() + " Precio: " + mazapan.getPrecio());
            } else if (opcion == 4) {
                txtOrdenSelec.setText("Pediste: " + cocacola.getProducto() + " Precio: " + cocacola.getPrecio());
            } else {
                txtOrdenSelec.setText("Número de producto no válido.");
            }
            
        } catch (NumberFormatException e) {
            txtOrdenSelec.setText("Por favor, introduce un número de ticket válido.");
        }
    }
}

class Productos {
    private int ticket;
    private String producto;
    private double precio;

    public Productos(int ticket, String producto, double precio) {
        this.ticket = ticket;
        this.producto = producto;
        this.precio = precio;
    }

    public int getTicket() {
        return ticket;
    }

    public void setTicket(int ticket) {
        this.ticket = ticket;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return ticket + " - " + producto + " ($" + precio + ")";
    }
}