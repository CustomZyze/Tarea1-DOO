package org.example;
import java.util.Scanner;

/**
 * Clase Main Interactiva donde se simula el funcionamiento de una maquina expendedora
 * Entrega una interfaz de usuario usando la consola que deja realizar compras,
 * escoger con que moneda pagas y ver si la operacion se pudo realizar o
 * se logro consumir un producto
 */
public class MainInteractivo {
    /**
     * Metodo principal del main interactivo
     * <p>
     * Inicia un while que mantiene el programa en ejecucion, mostrando las opciones en la terminal
     * Captura mediante scanner las entradas de teclado para poder navegar el menu, escoger que
     * producto comprar y con que moneda comprar.
     * <p>
     * Tambien atrapa las excepciones (falta de stock,pago incorrecto y dinero insuficiente)
     * y lo muestra sin detener el programa
     * <p>
     * @param args Argumentos que se usan en la linea de comeandos, antes de ejecutar
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Maquina Expendedora");
        int eleccion = 0;
        boolean maquina = true;
        Expendedor exp1 = new Expendedor(13);

        while (maquina) {
            System.out.println("Escoga que desea hacer:\n1.Comprar producto\n2.Salir\n");
            eleccion = s.nextInt();
            switch (eleccion) {
                case 1:
                    System.out.println("PRODUCTOS EN MAQUINA");
                    System.out.println("1.Coca Cola: $"+ Enumeracion.COCA_COLA.getPrecio()+"\n2.Sprite: $" +Enumeracion.SPRITE.getPrecio()+
                            "\n3.Fanta: $"+Enumeracion.FANTA.getPrecio()+"\n4.Super8: $"+Enumeracion.SUPER8.getPrecio()+ "\n5.Snickers: $"
                            +Enumeracion.SNICKERS.getPrecio() +"\n");

                    int eleccion2 = s.nextInt();
                    Moneda m = null;
                    Enumeracion producto = null;
                    switch (eleccion2){
                        case 1 -> producto = Enumeracion.COCA_COLA;
                        case 2 -> producto = Enumeracion.SPRITE;
                        case 3 -> producto = Enumeracion.FANTA;
                        case 4 -> producto = Enumeracion.SUPER8;
                        case 5 -> producto = Enumeracion.SNICKERS;
                    }


                    System.out.println("PAGAR CON: ");
                    System.out.println("1.$100\n2.$500\n3.1000");
                    int moneda = s.nextInt();
                    if(moneda == 1) {
                        m = new Moneda100();
                    }
                    if(moneda == 2) {
                        m = new Moneda500();
                    }
                    if(moneda == 3) {
                        m = new Moneda1000();
                    }

                    Comprador c1;
                    try {
                        c1 = new Comprador(m, producto, exp1);
                        System.out.println("Consumiste: " + c1.queConsumiste());
                        System.out.println("Vuelto: " + c1.cuantoVuelto()+"\n");

                    } catch (NoHayProductoException e) {
                        System.out.println("Error en la compra: " + e.getMessage());
                        System.out.println("Vuelto: " + exp1.getVuelto());
                    } catch (PagoIncorrectoException f) {
                        System.out.println("Error en la compra: " + f.getMessage());
                    } catch (PagoInsuficienteException g) {
                        System.out.println("Error en la compra: " + g.getMessage());
                        System.out.println("Vuelto: " + exp1.getVuelto());
                    }
                    break;

                case 2:
                    System.out.println("GRACIAS");
                    maquina = false;
                    break;
                default:
                    System.out.println("Seleccion no valida, intente de nuevo.\n");
            }
        }
    }
}
