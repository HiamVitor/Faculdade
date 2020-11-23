
package Controller;

import Model.Categoria;
import Model.Titulo;
import java.util.List;

public class daoTitulo extends dao<Titulo>{
    public List<Titulo> getList(){
        String JPQL="select t from Titulo t order by t.nome";
        return super.getList(JPQL);
    }
    @Override
    public List<Titulo> getList(String filtro){
        String JPQL="select t from Titulo t where t.nome like ?1 order by t.nome";
        return super.getList(JPQL,"%"+filtro.toUpperCase()+"%");
    }
    public List<Titulo> getList(Categoria categoria){
        String JPQL="select t from Titulo t where t.categoria = ?1 order by t.nome";
        return super.getList(JPQL,categoria);
    }
}
