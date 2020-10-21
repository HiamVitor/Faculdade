
package Controller;

import Model.Categoria;
import java.util.List;

public class daoCategoria extends dao<Categoria>{
    public List<Categoria> getList(){
        return super.getList("select c from Categoria c order by c.nome");
    }
    public List<Categoria> getList(String filtro){
        return super.getList("select c from Categoria c where c.nome like ?1 order by c.nome",filtro);
    }
}
