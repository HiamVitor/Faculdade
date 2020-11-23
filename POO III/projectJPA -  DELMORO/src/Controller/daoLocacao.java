
package Controller;

import Model.Locacao;
import java.util.List;

public class daoLocacao extends dao<Locacao>{
    public List<Locacao> getList(){
        String JPQL = "select l from Locacao l order by l.id";
        return super.getList(JPQL);
    }
    @Override
    public List<Locacao> getList(String cliente){
        String JPQL = "select l from Locacao l where l.cliente.nome like ?1 order by l.id";
        return super.getList(JPQL,cliente);
    }
}
