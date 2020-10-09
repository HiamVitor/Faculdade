
package Testes;

import TAD.Fila;

public class testeFilas {
    public static void main(String[] args) {
        //criar e iniciar
        Fila fila = new Fila();
        System.out.println(fila.enQueue("valor a"));
        System.out.println(fila.enQueue("valor b"));
        System.out.println(fila.enQueue("valor c"));
        System.out.println(fila.enQueue("valor d"));
        System.out.println(fila.enQueue("valor e"));
        System.out.println(fila.enQueue("valor f"));
        //        
        System.out.println(fila.firstQueue());
        System.out.println(fila.deQueue());

        System.out.println(fila.firstQueue());
        System.out.println(fila.deQueue());

        System.out.println(fila.firstQueue());
        System.out.println(fila.deQueue());

        System.out.println(fila.firstQueue());
        System.out.println(fila.deQueue());

        System.out.println(fila.firstQueue());
        System.out.println(fila.deQueue());

        System.out.println(fila.firstQueue());
        System.out.println(fila.deQueue());
        
    }
}
