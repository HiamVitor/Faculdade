
package cruds;

import Dados.Banco;
import enums.Estados;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
ORM
Object 
Relational
Mapping

MVC
Model (espelho das tabelas) ok
View (interface usuário) front
Controller (DAO data access object) back


Executar instrução SQL
1-SQL
2-Comando a utilizar: Statement/PreparedStatement
3-Parametros????
4-Executar: execute, executeUpdate(int), executeQuery(select)
*/
public class crudCidade {
    private static int add(String nome,Estados estado) throws SQLException{
        String SQL="INSERT INTO CIDADES(NOME,ESTADO) VALUES (?,?)";
        PreparedStatement pst = Banco.getConnection().prepareStatement(SQL);
        pst.setString(1, nome.toUpperCase());
        pst.setString(2, estado.name());
        return pst.executeUpdate();
    }
    
    public static void main(String[] args) {
        try{
            System.out.println(add("criciuma", Estados.SC));
            System.out.println(add("curitiba", Estados.PR));
            System.out.println(add("rio branco", Estados.AC));
            System.out.println(add("sao paulo", Estados.SP));
        }catch(SQLException ex){
            System.out.println("ERRO:"+ex.getMessage());
        }
    }
}
