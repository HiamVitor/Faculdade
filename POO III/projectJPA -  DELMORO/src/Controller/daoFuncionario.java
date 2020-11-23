
package Controller;

import Model.Funcionario;
import java.util.List;

public class daoFuncionario extends dao<Funcionario>{
    public List<Funcionario> getList(){
        String JPQL="select f from Funcionario f order by f.nome";
        return super.getList(JPQL);
    }
    @Override
    public List<Funcionario> getList(String filtro){
        String JPQL="select f from Funcionario f where f.nome like ?1 order by f.nome";
        return super.getList(JPQL,"%"+filtro.toUpperCase()+"%");
    }
}
