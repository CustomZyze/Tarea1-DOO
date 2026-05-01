package org.example;

public class Expendedor {
    private Deposito<Bebida> coca;
    private Deposito<Bebida> sprite;
    private Deposito<Moneda> monVu;
    private int precio;
    public static final int COCA=1;
    public static final int SPRITE=2;
    public Expendedor(int numBebidas, int precioBebidas){
        coca = new Deposito<Bebida>();
        sprite = new Deposito<Bebida>();
        monVu = new Deposito<Moneda>();
        precio = precioBebidas;
        for(int i = 0 ; i < numBebidas ; i++){
            coca.addAlgo(new CocaCola(100 + i));
            sprite.addAlgo(new Sprite(200 + i));

        }

    }
    public Bebida comprarBebida (Moneda m , int cual){
        if(m == null){
            return null;
        }
        if (m.getValor()< precio){
            monVu.addAlgo(m);
            return null;
        }
        Bebida b = null;
        if(cual == 1){
            b = coca.getAlgo();
        }
        else if(cual == 2){
            b = sprite.getAlgo();
        }
        else{
            monVu.addAlgo(m);
            return null;
        }

        if(b == null){
            monVu.addAlgo(m);
            return null;
        }

        int diferencia = m.getValor() - precio;

        for(int i = 0; i < diferencia; i += 100){
            monVu.addAlgo(new Moneda100());
        }

        return b;
    }

    public Moneda getVuelto(){
        return monVu.getAlgo();

    }
}
