
package Controller;

import Model.Curso;
import enums.Turnos;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class daoCurso extends dao{
    public int create(Curso curso) throws SQLException{  
        String SQL="INSERT INTO cursos(nome, turno) VALUES (?,?)";
        return super.executeUpdate(SQL, 
                curso.getNome(),
                curso.getTurno().name());
    }
    public int update(Curso curso) throws SQLException{ 
        String SQL="UPDATE cursos SET nome=?, turno=? WHERE id=?";
        return super.executeUpdate(SQL, 
                curso.getNome(),
                curso.getTurno().name(),
                curso.getId());
    }
    public int delete(Curso curso) throws SQLException{     
        return super.executeUpdate("delete from cursos where id="+curso.getId());
    }
    //
    public Curso retrieve(int id) throws SQLException{    
        String SQL="SELECT * FROM CURSOS WHERE ID="+id;
        ResultSet rs = super.executeQuery(SQL);
        return (rs.next() ? this.createObject(rs) : null);
    }
    public List<Curso> getList() throws SQLException{   
        String SQL="SELECT * FROM CURSOS ORDER BY NOME";
        ResultSet rs = super.executeQuery(SQL);
        List<Curso> retorno = new LinkedList<>();
        while (rs.next()){
            retorno.add(this.createObject(rs));
        }
        return retorno;        
    }
    public List<Curso> getList(String filtro) throws SQLException{        
        String SQL="SELECT * FROM CURSOS WHERE NOME LIKE ? ORDER BY NOME";
        ResultSet rs = super.executeQuery(SQL,"%"+filtro.toUpperCase()+"%");
        List<Curso> retorno = new LinkedList<>();
        while (rs.next()){
            retorno.add(this.createObject(rs));
        }
        return retorno;        
    }
    //
    private Curso createObject(ResultSet rs) throws SQLException{    
        return (
                new Curso(
                        rs.getInt("ID"), 
                        rs.getString("NOME"), 
                        Turnos.valueOf(rs.getString("TURNO"))
                )
        );
    }           
}
