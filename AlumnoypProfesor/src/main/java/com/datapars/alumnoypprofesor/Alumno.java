package com.datapars.alumnoypprofesor;

public class Alumno extends Persona {

    public Alumno() {
        super();
    }

    @Override
    public String toString() {
        return "Un alumno llamado: " + nombre;
    }
}