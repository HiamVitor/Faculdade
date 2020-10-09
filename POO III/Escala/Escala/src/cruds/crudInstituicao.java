
package cruds;

import Controller.daoCidade;
import Controller.daoInstituicao;
import Model.Cidade;
import Model.Instituicao;
import enums.Estados;
import java.sql.SQLException;

public class crudInstituicao {
    public static void main(String[] args) {
        daoInstituicao dao = new daoInstituicao();
        try{
            dao.create(new Instituicao(0, "esucri", "goncalves ledo", "11.222.333/4444-55", 
                    new Cidade(1, "criciuma", Estados.ES)));
            
            dao.create(new Instituicao(0, "ufsc", "avenida", "11.111.111/1111-11", 
                    new daoCidade().retrieve(5)));
            
        }catch(SQLException ex){
            System.out.println("ERRO:"+ex.getMessage());
            ex.printStackTrace();
        }
    }
    
}
