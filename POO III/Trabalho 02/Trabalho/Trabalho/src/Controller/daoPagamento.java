package Controller;

import Model.Pagamento;
import java.util.List;

public class daoPagamento extends dao<Pagamento> {
    
    public List<Pagamento> getList() {
        String JPQL = "select t from Pagamento t order by t.nome";
        return super.getList(JPQL);
    }
    
    @Override
    public List<Pagamento> getList(String filtro) {
        String JPQL = "select t from Pagamento t where t.nome like ?1 order by t.nome";
        return super.getList(JPQL, "%" + filtro.toUpperCase() + "%");
    }
}
