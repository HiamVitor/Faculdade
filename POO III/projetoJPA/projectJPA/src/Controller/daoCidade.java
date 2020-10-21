
package Controller;

import Model.Cidade;
import java.util.List;

public class daoCidade extends dao<Cidade>{

    public List<Cidade> getList(){
        String JPQL="select c from Cidade c order by c.nome";
        return super.getList(JPQL);
    }
    
    public List<Cidade> getList(String filtro){
        String JPQL="select c from Cidade c where c.nome like ?1 order by c.nome";        
        return super.getList(JPQL, filtro);
    }
}
