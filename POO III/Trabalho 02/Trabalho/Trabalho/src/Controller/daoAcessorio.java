package Controller;

import Model.Acessorio;
import java.util.List;

public class daoAcessorio extends dao<Acessorio> {

    public List<Acessorio> getList() {
        String JPQL = "select t from Acessorio t order by t.nome";
        return super.getList(JPQL);
    }

    @Override
    public List<Acessorio> getList(String filtro) {
        String JPQL = "select t from Acessorio t where t.nome like ?1 order by t.nome";
        return super.getList(JPQL, "%" + filtro.toUpperCase() + "%");
    }
}
