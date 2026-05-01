package org.example;

public class Comprador {
        private String sabor;
        private int vuelto;
        public Comprador(Moneda m, int cualProducto, Expendedor exp) throws PagoIncorrectoException, NoHayProductoException, PagoInsuficienteException{
            
            Producto p = exp.comprarProducto(m , cualProducto);
            if( p != null){
                this.sabor = p.consumir();
            }

            Moneda v;

            while((v = exp.getVuelto()) != null){
                this.vuelto = vuelto +  v.getValor();
            }


        }
        public int cuantoVuelto(){
            return vuelto;
        }
        public String queConsumiste(){
            return sabor;
        }
}
