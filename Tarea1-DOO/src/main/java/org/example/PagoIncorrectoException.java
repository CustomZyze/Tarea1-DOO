package org.example;

public class PagoIncorrectoException extends Exception{
    public PagoIncorrectoException(){
        super("No Ingreso Moneda");
    }
}
