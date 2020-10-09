package Testes;
        
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class comandosBanco {
    public static void main(String[] args) {
        Connection connection = null;
        Statement st = null;
        PreparedStatement pst = null;
        String url="jdbc:postgresql://localhost:5432/Objetos";
        String usr="postgres";
        String pdw="postgres";
        //
        try{
            connection = DriverManager.getConnection(url, usr, pdw);
            st = connection.createStatement();
            pst = connection.prepareStatement(""
                    + "insert into setor (nome) values (?)");
            System.out.println("Conectado");            
        }catch(SQLException ex){
            System.out.println("ERRO"+ex.getMessage());
        }
        try{
            pst.setString(1, "TI");
            pst.execute();
        }catch(SQLException ex){
            System.out.println("ERRO:"+ex.getMessage());
        }
        
    }
    
}
