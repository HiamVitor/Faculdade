package Controller;

import Model.Marca;
import Model.Modelo;
import java.util.List;

public class daoModelo extends dao<Modelo> {

    public List<Modelo> getList() {
        String JPQL = "select t from Modelo t order by t.nome";
        return super.getList(JPQL);
    }

    @Override
    public List<Modelo> getList(String filtro) {
        String JPQL = "select t from Modelo t where t.nome like ?1 order by t.nome";
        return super.getList(JPQL, "%" + filtro.toUpperCase() + "%");
    }

    public List<Modelo> getList(Marca marca) {
        String JPQL = "select t from Modelo t where t.marca = ?1 order by t.nome";
        return super.getList(JPQL, marca);
    }
}
