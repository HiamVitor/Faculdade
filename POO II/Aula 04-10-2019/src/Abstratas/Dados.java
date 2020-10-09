
package Abstratas;

import Classes.Cliente;
import Classes.Equipamento;
import Classes.Ordem;
import Classes.Tecnico;
import java.util.LinkedList;

abstract public class Dados {
    private static LinkedList<Cliente> listaCliente=new LinkedList<>();
    private static LinkedList<Equipamento> listaEquipamento=new LinkedList<>();
    private static LinkedList<Ordem> listaOrdem=new LinkedList<>();
    private static LinkedList<Tecnico> listaTecnico=new LinkedList<>();

    public static LinkedList<Cliente> getListaCliente() {
        return listaCliente;
    }

    public static LinkedList<Equipamento> getListaEquipamento() {
        return listaEquipamento;
    }

    public static LinkedList<Ordem> getListaOrdem() {
        return listaOrdem;
    }

    public static LinkedList<Tecnico> getListaTecnico() {
        return listaTecnico;
    }
    
    
    
}
