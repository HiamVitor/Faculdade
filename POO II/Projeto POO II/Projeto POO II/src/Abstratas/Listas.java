
package Abstratas;

import Classes.Cliente;
import Classes.Produtos;
import Classes.Servicos;
import java.util.LinkedList;

abstract public class Listas {
    //
    private static LinkedList<Cliente> listaCliente=new LinkedList<>();
    //
    private static double valorHoraServico;
    //
    private static LinkedList<Produtos> listaProduto = new LinkedList<>();
    //
    private static LinkedList<Servicos> listaServico =  new LinkedList<>();
    //
    private static LinkedList<Base> listaFatura = new LinkedList<>();
    //
    public static void setValorHoraServico(double valorHora){
        valorHoraServico=valorHora <= 0 ? 0.01 : valorHora;
    }
    //
    public static double getValorHoraServico(){
        return valorHoraServico;
    }
    //
    public static LinkedList<Produtos> getListaProduto(){
        return listaProduto;
    }
    //
    public static LinkedList<Servicos> getListaServico(){
        return listaServico;
    }
    //
    public static LinkedList<Base> getListaFatura(){
        return listaFatura;
    }
    //
    public static LinkedList<Cliente> getListaCliente() {
        return listaCliente;
    }
}
