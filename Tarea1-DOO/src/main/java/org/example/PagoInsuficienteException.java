package org.example;

public class PagoInsuficienteException extends Exception {
    public PagoInsuficienteException(){
        super("No ingreso cantidad necesaria");
    }
}
