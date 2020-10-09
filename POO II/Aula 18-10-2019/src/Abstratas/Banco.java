
package Abstratas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

abstract public class Banco {
    private static Connection connection = null;
    
    public  static Connection getConnection() throws SQLException{
            String url="jdbc:postgresql://localhost:5432/Objetos";
            String usr="postgres";
            String pdw="postgres";
            if (connection == null){
                connection = DriverManager.getConnection(url,usr,pdw);
            }
            return connection;
    }
}
