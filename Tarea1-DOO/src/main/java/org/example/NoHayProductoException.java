package org.example;

public class NoHayProductoException extends Exception{
    public NoHayProductoException(){
        super("no hay producto disponible");
    }
}
