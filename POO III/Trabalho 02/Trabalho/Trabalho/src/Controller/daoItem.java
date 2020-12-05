package Controller;

import Model.Item;
import Model.Acessorio;
import Model.ItensVeiculo;
import java.util.List;

public class daoItem extends dao<Item> {

    public List<Item> getList(ItensVeiculo itensVeiculo) {
        String JPQL = "select i from Item i where i.itensVeiculo = ?1 order by i.acessorio.nome";
        return super.getList(JPQL, itensVeiculo);
    }

    public List<Item> getList(Acessorio acessorio) {
        String JPQL = "select i from Item i where i.acessorio = ?1";
        return super.getList(JPQL, acessorio);
    }
}
