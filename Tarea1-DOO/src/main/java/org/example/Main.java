package org.example;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Expendedor exp1= new Expendedor(0);
        Expendedor exp2 = new Expendedor(12);

        System.out.println("TESTEO DE EXCEPCIONES");
        //Prueba NoHayStock (Sin Stock de producto)
        try {
            Moneda m1000 = new Moneda1000();
            Comprador c1 = new Comprador(m1000, Enumeracion.SNICKERS, exp1);
            System.out.println("Consumiste: " + c1.queConsumiste());
            System.out.println("Vuelto: " + c1.cuantoVuelto());
        } catch (NoHayProductoException e) {
            System.out.println("Error en la compra: " + e.getMessage());
            System.out.println("Vuelto: " + exp1.getVuelto());
        } catch (PagoIncorrectoException f) {
            System.out.println("Error en la compra: " + f.getMessage());
        } catch (PagoInsuficienteException g) {
            System.out.println("Error en la compra: " + g.getMessage());
            System.out.println("Vuelto: " + exp1.getVuelto());
        }

        //Prueba NoHayStock2 (Producto no esta en las opciones de la maquina (o sea null)

        try {
            Moneda m1000 = new Moneda1000();
            Comprador c1 = new Comprador(m1000, null, exp2);
            System.out.println("Consumiste: " + c1.queConsumiste());
            System.out.println("Vuelto: " + c1.cuantoVuelto());
        } catch (NoHayProductoException e) {
            System.out.println("Error en la compra: " + e.getMessage());
            System.out.println("Vuelto: " + exp2.getVuelto());
        } catch (PagoIncorrectoException f) {
            System.out.println("Error en la compra: " + f.getMessage());
        } catch (PagoInsuficienteException g) {
            System.out.println("Error en la compra: " + g.getMessage());
            System.out.println("Vuelto: " + exp2.getVuelto());
        }

        //Prueba PagoIncorrecto
        try {
            Comprador c1 = new Comprador(null, Enumeracion.SNICKERS, exp2);
            System.out.println("Consumiste: " + c1.queConsumiste());
            System.out.println("Vuelto: " + c1.cuantoVuelto());
        } catch (NoHayProductoException e) {
            System.out.println("Error en la compra: " + e.getMessage());
            System.out.println("Vuelto: " + exp2.getVuelto());
        } catch (PagoIncorrectoException f) {
            System.out.println("Error en la compra: " + f.getMessage());
        } catch (PagoInsuficienteException g) {
            System.out.println("Error en la compra: " + g.getMessage());
            System.out.println("Vuelto: " + exp2.getVuelto());
        }

        //Prueba PagoInsuficiente

        try {
            Moneda m100 = new Moneda100();
            Comprador c1 = new Comprador(m100, Enumeracion.SNICKERS, exp2);
            System.out.println("Consumiste: " + c1.queConsumiste());
            System.out.println("Vuelto: " + c1.cuantoVuelto());
        } catch (NoHayProductoException e) {
            System.out.println("Error en la compra: " + e.getMessage());
            System.out.println("Vuelto: " + exp2.getVuelto());
        } catch (PagoIncorrectoException f) {
            System.out.println("Error en la compra: " + f.getMessage());
        } catch (PagoInsuficienteException g) {
            System.out.println("Error en la compra: " + g.getMessage());
            System.out.println("Vuelto: " + exp2.getVuelto());
        }

        System.out.println();

        //Prueba Normal
        System.out.println("PRUEBA DE CADA PRODUCTO");
        Expendedor exp3 = new Expendedor(12);
        for (Enumeracion prod : Enumeracion.values()) {
            try {
                Moneda m1000 = new Moneda1000();
                Comprador c1 = new Comprador(m1000, prod, exp3);
                System.out.println("Consumiste: " + c1.queConsumiste());
                System.out.println("Vuelto: " + c1.cuantoVuelto());
            } catch (NoHayProductoException e) {
                System.out.println("Error en la compra: No queda stock.");
            } catch (PagoIncorrectoException e) {
                System.out.println("Error en la compra: Moneda nula.");
            } catch (PagoInsuficienteException e) {
                System.out.println("Error en la compra: Dinero insuficiente.");
            }
        }

        //Prueba sorteo moneda
        ArrayList<Moneda> listaMonedas = new ArrayList<>();

        listaMonedas.add(new Moneda100());
        listaMonedas.add(new Moneda1000());
        listaMonedas.add(new Moneda500());
        listaMonedas.add(new Moneda100());
        listaMonedas.add(new Moneda100());
        listaMonedas.add(new Moneda500());
        listaMonedas.add(new Moneda1000());
        listaMonedas.add(new Moneda100());
        listaMonedas.add(new Moneda500());

        System.out.println("Lista desordenada: " + listaMonedas);
        listaMonedas.sort(null);
        System.out.println("Lista ordenada: " + listaMonedas);

    }
}
