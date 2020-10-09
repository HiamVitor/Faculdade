
package Testes;

import Tad.Pilha;

public class testeTAD {
    public static void main(String[] args) {
        Pilha pilha = new Pilha();
        System.out.println(pilha.pushStack("Valor 1"));
        System.out.println(pilha.pushStack("Valor 2"));
        System.out.println(pilha.pushStack("Valor 3"));
        System.out.println(pilha.pushStack("Valor 4"));
        System.out.println(pilha.pushStack("Valor 5"));
        System.out.println(pilha.pushStack("Valor 6"));
        //
        System.out.println("topo: "+pilha.topStack());
        //
        System.out.println(pilha.popStack());
        System.out.println(pilha.popStack());
        System.out.println(pilha.popStack());
        //
        System.out.println("topo: "+pilha.topStack());
        //
        System.out.println(pilha.popStack());
        System.out.println(pilha.popStack());
        System.out.println(pilha.popStack());
        //
        System.out.println("topo: "+pilha.topStack());
    }
}
