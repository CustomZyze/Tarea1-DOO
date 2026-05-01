package org.example;

public enum Enumeracion{
    COCA_COLA(1000),
    SPRITE(800),
    FANTA(800),
    SUPER8(300),
    SNICKERS(600);

    private final int precio;

    Enumeracion(int precio){
        this.precio=precio;
    }

    public int getPrecio(){
        return precio;
    }
}