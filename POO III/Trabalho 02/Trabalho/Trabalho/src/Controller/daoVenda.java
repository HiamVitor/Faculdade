package Controller;

import Model.Pagamento;
import Model.Venda;
import Model.Vendedor;
import java.util.List;

public class daoVenda extends dao<Venda> {

    public List<Venda> getList() {
        String JPQL = "select f from Venda f order by f.id";
        return super.getList(JPQL);
    }

    public List<Venda> getList(Vendedor vendedor) {
        return super.getList("select r from Venda r where r.vendedor = ?1 order by r.vendedor", vendedor);
    }

    public List<Venda> getList(Pagamento pagamentos) {
        String JPQL
                = "select t from Venda t where t.pagamento = ?1 order by t.id";
        return super.getList(JPQL, pagamentos);
    }
}
