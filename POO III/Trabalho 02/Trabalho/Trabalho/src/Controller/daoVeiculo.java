package Controller;

import Model.Modelo;
import Model.Veiculo;
import java.util.List;

public class daoVeiculo extends dao<Veiculo> {

    public List<Veiculo> getList() {
        String JPQL = "select t from Veiculo t order by t.nome";
        return super.getList(JPQL);
    }

    @Override
    public List<Veiculo> getList(String filtro) {
        String JPQL = "select t from Veiculo t where t.nome like ?1 order by t.nome";
        return super.getList(JPQL, "%" + filtro.toUpperCase() + "%");
    }

    public List<Veiculo> getList(Modelo modelo) {
        String JPQL = "select t from Veiculo t where t.modelo = ?1 order by t.nome";
        return super.getList(JPQL, modelo);
    }
}
