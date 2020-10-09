package Estaticos;

import Classes.Produto;
import Classes.Vendedor;
import java.util.LinkedList;

abstract public class Dados {
    private static double cotacao;
    private static LinkedList<Vendedor> ListaVendedor = new LinkedList<>();
    private static LinkedList<Produto> ListaProduto = new LinkedList<>();
    
    //Set
    public static void setCotacao (double param){
        cotacao = param <0.01 ? 0.01 : param;
    }
    //Get
    public static double getCotacao(){
        return cotacao;
    }
    public static LinkedList<Vendedor> getListaVendedor(){
        return ListaVendedor;
    }
    public static LinkedList<Produto> getListaProduto(){
            return ListaProduto;
    }
    
}
