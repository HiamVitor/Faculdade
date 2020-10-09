package Dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

abstract public class Banco{
    private static Connection connection = null;
    private static Statement statement = null;
    
    public static Statement getStatement() throws SQLException{
        if(statement==null){
            statement=getConnection().createStatement();
        }
        return statement;
    }

    public static Connection getConnection() throws SQLException{
        if (connection == null){
            String url="jdbc:postgresql://localhost:5432/Revisao";
            String usr="postgres";
            String pwd="postgres";
            connection = DriverManager.getConnection(url,usr,pwd);
        }
        return connection;
    }
}
