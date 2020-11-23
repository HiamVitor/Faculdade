
package Controller;

import Model.Item;
import Model.Locacao;
import Model.Titulo;
import java.util.List;

public class daoItem extends dao<Item>{
    public List<Item> getList(Locacao locacao){
        String JPQL = "select i from Item i where i.locacao = ?1 order by i.titulo.nome";
        return super.getList(JPQL, locacao);
    }
    public List<Item> getList(Titulo titulo){
        String JPQL = "select i from Item i where i.titulo = ?1";
        return super.getList(JPQL, titulo);
    }
}
