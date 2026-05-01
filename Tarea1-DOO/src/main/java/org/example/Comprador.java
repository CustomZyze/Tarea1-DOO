package org.example;

public class Comprador {
        private String sonido;
        private int vuelto;
        public Comprador(Moneda m, int cualBebida, Expendedor exp){
            Bebida b = exp.comprarBebida(m , cualBebida);
            Moneda v;
            if( b != null){
                sonido = b.beber();
            }
            else {
                sonido = null;
            }
            while((v = exp.getVuelto()) != null){
                vuelto = vuelto +  v.getValor();
            }


        }
        public int cuantoVuelto(){
            return vuelto;
        }
        public String queBebiste(){
            return sonido;
        }
}
