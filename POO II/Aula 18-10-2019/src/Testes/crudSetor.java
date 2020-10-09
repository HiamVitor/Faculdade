
package Testes;

import Abstratas.Banco;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class crudSetor {
    public static int create(Statement st,String nome) throws SQLException{
        String SQL = "insert into setor (nome) values ('" + nome.toUpperCase()+"')";
        return st.executeUpdate(SQL);        
    }
    public static int update(int id,String nome) throws SQLException{
        String sql = "update setor set nome=? where id=?";
        //"update setor set nome='"+nome.toUpperCase()+"' where id="+id
        PreparedStatement pst = 
                Banco.getConnection().prepareStatement(sql);
        pst.setString(1, nome.toUpperCase());
        pst.setInt(2,id);
        return pst.executeUpdate();        
    }
    public static int delete(Statement st,int id) throws SQLException{
        String SQL = "delete from setor where id=" + id;
        return st.executeUpdate(SQL);
    }
    
    
    public static void main(String[] args) {
        Statement st = null;
        try{
            st = Banco.getConnection().createStatement();
        }catch(SQLException ex){
            System.out.println("ERRO:"+ex.getMessage());
        }
        try{
            /*
            System.out.println(create(st, "financeiro"));
            System.out.println(create(st, "gerencia"));
            System.out.println(create(st, "adminitrativo"));
            System.out.println(create(st, "comercial"));
            System.out.println(create(st, "operacional"));
            */
            System.out.println("Atualizados:"+update(333, "gerência"));
            System.out.println("Removidos: " + delete(st, 4));
        }catch(SQLException ex){
            System.out.println("ERRO:"+ex.getMessage());
        }
    }    
}
