
package Abstratas;

import Classes.Produto;
import Classes.Servico;
import java.util.LinkedList;

public class Dados {
    private static double valorHoraServico;
    //
    private static LinkedList<Produto> listaProduto = 
    new LinkedList<>();
    //
    private static LinkedList<Servico> listaServico = 
    new LinkedList<>();
    //
    private static LinkedList<Item> listaFatura = 
    new LinkedList<>();
    //
    public static void setValorHoraServico(double valorHora){
        valorHoraServico=valorHora <=0 ? 0.01 : valorHora;
    }
    public static double getValorHoraServico(){
        return valorHoraServico;
    }
    //
    public static LinkedList<Produto> getListaProduto(){
        return listaProduto;
    }
    public static LinkedList<Servico> getListaServico(){
        return listaServico;
    }
    public static LinkedList<Item> getListaFatura(){
        return listaFatura;
    }
    
}
