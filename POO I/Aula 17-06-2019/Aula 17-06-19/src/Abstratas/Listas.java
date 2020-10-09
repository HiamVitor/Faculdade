package Abstratas;

import Classes.Fisica;
import Classes.Juridica;
import Classes.Produto;
import java.util.LinkedList;

abstract public class Listas {
    private static LinkedList<Produto> listaProduto = 
            new LinkedList<>();
    private static LinkedList<Fisica> listaFisica = 
            new LinkedList<>();
    private static LinkedList<Juridica> listaJuridica = 
            new LinkedList<>();  
    
    public static LinkedList<Produto> getListaProduto(){
        return listaProduto;
    }
    public static LinkedList<Fisica> getListaFisica(){
        return listaFisica;
    }
    public static LinkedList<Juridica> getListaJuridica(){
        return listaJuridica;
    }
}
