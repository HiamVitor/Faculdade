
package cruds;

import Controller.daoInstituicao;
import Controller.daoProfessor;
import Model.Professor;
import enums.Sexos;
import enums.Titulacoes;
import java.sql.SQLException;
import java.time.LocalDate;

public class crudProfessor {
    public static void main(String[] args) {
        daoProfessor dao = new daoProfessor();
        //
        try{
            Professor p1 = new Professor(0, 
                    "joaquim de souza", LocalDate.now(), 
                    "111.222.333-44", 
                    Sexos.M, 
                    Titulacoes.GRA, 
                    new daoInstituicao().retrieve(1));
            System.out.println(dao.create(p1));
        }catch(SQLException ex){
            System.out.println("ERRO:"+ex.getMessage());
        }
    }
    
}
