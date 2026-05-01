package org.example;

import java.util.ArrayList;

public class Deposito<T> {
    private ArrayList<T> lista;
    public Deposito(){
        lista = new ArrayList<T>();
    }
    public void addAlgo(T a){
        lista.add(a);
    }
    public T getAlgo(){
        if(lista.size() == 0){
            return null;
        }
        return lista.remove(0);
    }
}
