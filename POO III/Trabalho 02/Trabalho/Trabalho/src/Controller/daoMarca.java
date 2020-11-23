package Controller;

import Model.Marca;
import java.util.List;

public class daoMarca extends dao<Marca> {

        
    public List<Marca> getList() {
        String JPQL = "select t from Marca t order by t.id";
        return super.getList(JPQL);
    }

    @Override
    public List<Marca> getList(String filtro) {
        String JPQL = "select t from Marca t where t.nome like ?1 order by t.nome";
        return super.getList(JPQL, "%" + filtro.toUpperCase() + "%");
    }
}
