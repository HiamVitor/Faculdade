
package Classes;

import Dados.Banco;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class crudCurso {
    public static int add(String nome) throws SQLException{
        String SQL = "INSERT INTO CURSO(NOME) VALUES (?)";
        PreparedStatement pst = 
        Banco.getConnection().prepareStatement(SQL);
        pst.setString(1, nome.toUpperCase());
        return pst.executeUpdate();
    }  
    public static int update(int id,String nome) throws SQLException{
        String SQL="UPDATE CURSO SET NOME=? WHERE ID=?";
        PreparedStatement pst = 
        Banco.getConnection().prepareStatement(SQL);
        pst.setString(1, nome.toUpperCase());
        pst.setInt(2, id);
        return pst.executeUpdate();
    }
    public static int delete(int id) throws SQLException{
        String SQL="DELETE FROM CURSO WHERE ID="+id;
        return Banco.getStatement().executeUpdate(SQL);
    }
    public static ResultSet get(int id) throws SQLException{
        String SQL="SELECT * FROM CURSO WHERE ID="+id;
        return Banco.getStatement().executeQuery(SQL);
    }
    public static ResultSet get() throws SQLException{
        String SQL="SELECT * FROM CURSO ORDER BY CURSO.NOME";
        PreparedStatement pst = 
        Banco.getConnection().prepareStatement(SQL);
        return pst.executeQuery();
    }
    public static void main(String[] args) {
        try{
            /*
            System.out.println("Adicionado:"+add("sistemas"));
            System.out.println("Adicionado:"+add("adminitração"));
            System.out.println("Adicionado:"+add("psicologia"));
            System.out.println("Adicionado:"+add("educação física"));
            System.out.println("Adicionado:"+add("engenharia civil"));
            System.out.println("Atualizado:"+
                    update(1, "sistemas de informação"));
            System.out.println("Removido:"+delete(2));
            */
            ResultSet rs = get(1);
            if (rs.next()){
                System.out.println("Encontrado:"+
                rs.getInt("ID")+"\t"+rs.getString("NOME"));
            }else{
                System.out.println("Não Localizado");
            }
            System.out.println("=================");
            rs = get();
            while (rs.next()){
                System.out.println("Encontrado:"+
                rs.getInt("ID")+"\t"+rs.getString("NOME"));
            }            
        }catch(SQLException ex){
            System.out.println("ERRO:"+ex.getMessage());
        }
    }
}
