package Abstratas;

import Classes.Combustivel;
import Classes.Consumo;
import Classes.Posto;
import java.util.LinkedList;

public abstract class Listas {
     private static double valorLitro;
    private static LinkedList<Combustivel> listaCombustivel = new LinkedList<>();
    private static LinkedList<Posto> listaPosto = new LinkedList<>();
    private static LinkedList<Consumo> listaConsumo = new LinkedList<>();
    
    public static void setValorLitro (double param){
        valorLitro = param <0.01 ? 0.01 : param;
    }
    //Get
    public static double getValorLitro(){
        return valorLitro;}
    
     public static LinkedList<Combustivel> getListaCombustivel(){
        return listaCombustivel;
    }
     public static LinkedList<Posto> getListaPosto(){
        return listaPosto;
    }
     public static LinkedList<Consumo> getListaConsumo(){
         return listaConsumo;
     }

}
           
