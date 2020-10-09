package Estaticas;

import Classes.Produto;
import Classes.Servico;
import Enum.Origem;
import java.util.LinkedList;

abstract public class listas {
   private static LinkedList<Produto> listaProduto = new LinkedList<>();
   private static LinkedList<Servico> listaServico = new LinkedList<>();
   
   public static LinkedList<Produto> getListaProduto() {
        return listaProduto;
    }
   public static LinkedList<Servico> getListaServico() {
        return listaServico;
    }
}
