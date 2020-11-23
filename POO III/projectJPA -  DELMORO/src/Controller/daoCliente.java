
package Controller;

import Model.Cidade;
import Model.Cliente;
import java.util.List;

public class daoCliente extends dao<Cliente>{
    public List<Cliente> getList(){
        String JPQL="select c from Cliente c order by c.nome";
        return super.getList(JPQL);
    }
    public List<Cliente> getList(String filtro){
        String JPQL="select c from Cliente c where c.nome like ?1 order by c.nome";
        return super.getList(JPQL,filtro);
    }
    public List<Cliente> getList(Cidade cidade){
        String JPQL="select c from Cliente c where c.cidade = ?1 order by c.nome";
        return super.getList(JPQL,cidade);
    }    
}
