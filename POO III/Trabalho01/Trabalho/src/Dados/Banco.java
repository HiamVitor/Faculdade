
package Dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

abstract public class Banco {
    private static Connection connection = null;
    
    public static Connection getConnection() throws SQLException{
        if (connection == null){
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/Alocacao", 
                    "postgres", 
                    "postgres");
        }
        return connection;
    }
}
