package Controller;

import Model.ItensVeiculo;
import java.util.List;

public class daoItensVeiculo extends dao<ItensVeiculo> {

    public List<ItensVeiculo> getList() {
        String JPQL = "select l from ItensVeiculo l order by l.id";
        return super.getList(JPQL);
    }

    @Override
    public List<ItensVeiculo> getList(String veiculo) {
        String JPQL = "select l from ItensVeiculo l where l.veiculo.nome like ?1 order by l.id";
        return super.getList(JPQL, veiculo);
    }
}
