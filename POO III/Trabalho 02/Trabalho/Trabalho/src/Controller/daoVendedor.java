
package Controller;

import Model.Cidade;
import Model.Vendedor;
import java.util.List;

public class daoVendedor extends dao<Vendedor>{
    public List<Vendedor> getList(){
        String JPQL="select c from Vendedor c order by c.nome";
        return super.getList(JPQL);
    }
    public List<Vendedor> getList(String filtro){
        String JPQL="select c from Vendedor c where c.nome like ?1 order by c.nome";
        return super.getList(JPQL,filtro);
    }
    public List<Vendedor> getList(Cidade cidade){
        String JPQL="select c from Vendedor c where c.cidade = ?1 order by c.nome";
        return super.getList(JPQL,cidade);
    }    
}
