package com.datapars.figuras;

public class Circulo extends FiguraCircular {

    public Circulo(int radio) {
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * Math.pow(radio, 2);
    }

    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }

    @Override
    public String imprimeFigura() {
        return String.format("Se imprime una FiguraPlana...\n\nSe imprime un Circulo con radio: %d, area: %.2f, perimetro: %.2f", radio, calcularArea(), calcularPerimetro());
    }
}