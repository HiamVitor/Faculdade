
package cruds;

import Controller.daoCidade;
import Model.Cidade;
import enums.Estados;
import java.sql.SQLException;

public class testeDaoCidade {
    public static void main(String[] args) {
        Cidade cidade1 = new Cidade(0, "florianopolis", Estados.SC);
        Cidade cidade2 = new Cidade(0, "porto alegre", Estados.RS);
        Cidade cidade3 = new Cidade(0, "salvador", Estados.BA);
        //criar dao de ações
        daoCidade dao = new daoCidade();
        //adicionar
        try{
            /*
            System.out.println(dao.create(cidade1));
            System.out.println(dao.create(cidade2));
            System.out.println(dao.create(cidade3));
            */
            cidade1 = dao.retrieve(3);
            if (cidade1==null){
                System.out.println("Não Localizado");
            }else{
                System.out.println(cidade1.getNome()+"\t"+cidade1.getEstado());
                cidade1.setNome("epitaciolandia");
                //System.out.println(dao.update(cidade1));
                //remover
                System.out.println("Removidos:"+dao.delete(cidade1));
            }
            
        }catch(SQLException ex){
            System.out.println("ERRO:"+ex.getMessage());
        }
    }
}
