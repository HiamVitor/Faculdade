
package Controller;

import Dados.Banco;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;

abstract public class dao {
    
    private PreparedStatement getStatement(String SQL) throws SQLException{
        return Banco.getConnection().prepareStatement(SQL);        
    }
    private Statement getStatement() throws SQLException{
        return Banco.getConnection().createStatement();        
    }
    //executar um comando SQL que retorna int
    public int executeUpdate(String SQL,Object... args) throws SQLException{
        PreparedStatement pst = this.getStatement(SQL);
        for(int i=0; i < args.length; i++){
            pst.setObject((i+1), args[i]);
        }
        return pst.executeUpdate();
    }
    //executar um comando SQL que retorna ResultSet
    public ResultSet executeQuery(String SQL,Object... args) throws SQLException{
        PreparedStatement pst = this.getStatement(SQL);
        for(int i=0; i < args.length; i++){
            pst.setObject((i+1), args[i]);
        }
        return pst.executeQuery();
    }
}
