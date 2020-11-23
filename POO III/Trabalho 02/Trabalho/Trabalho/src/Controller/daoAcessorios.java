package Controller;

import Model.Acessorios;
import java.util.List;

public class daoAcessorios extends dao<Acessorios> {

    public List<Acessorios> getList() {
        String JPQL = "select t from Acessorios t order by t.nome";
        return super.getList(JPQL);
    }

    @Override
    public List<Acessorios> getList(String filtro) {
        String JPQL = "select t from Acessorios t where t.nome like ?1 order by t.nome";
        return super.getList(JPQL, "%" + filtro.toUpperCase() + "%");
    }
}
