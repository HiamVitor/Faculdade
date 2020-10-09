
package Controller;

import Model.Curso;
import Model.Disciplina;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class daoDisciplina extends dao{
    public int create(Disciplina disciplina) throws SQLException{  
        String SQL="INSERT INTO disciplinas(nome, credito, semipresencial, id_curso, id_professor) VALUES (?, ?, ?, ?, ?)";
        return super.executeUpdate(SQL, 
                disciplina.getNome(),
                disciplina.getCredito(),
                disciplina.isSemiPresencial(),
                disciplina.getCurso().getId(),
                disciplina.getProfessor().getId());
    }
    public int update(Disciplina disciplina) throws SQLException{  
        String SQL="UPDATE disciplinas SET nome=?, credito=?, semipresencial=?, id_curso=?, id_professor=? WHERE id=?";
        return super.executeUpdate(SQL,
                disciplina.getNome(),
                disciplina.getCredito(),
                disciplina.isSemiPresencial(),
                disciplina.getCurso().getId(),
                disciplina.getProfessor().getId(),
                disciplina.getId()
                );
    }
    public int delete(Disciplina disciplina) throws SQLException{       
        return super.executeUpdate("delete from disciplinas where id="+disciplina.getId());
    }
    //
    public Disciplina retrieve(int id) throws SQLException{      
        String SQL="SELECT * FROM DISCIPLINAS WHERE ID="+id;
        ResultSet rs = super.executeQuery(SQL);
        return (rs.next() ? this.createObject(rs) : null);        
    }
    public List<Disciplina> getList() throws SQLException{        
        String SQL="SELECT * FROM DISCIPLINAS ORDER BY NOME";
        ResultSet rs = super.executeQuery(SQL);
        List<Disciplina> retorno = new LinkedList<>();
        while (rs.next()){
            retorno.add(this.createObject(rs));
        }
        return retorno;         
    }    
    public List<Disciplina> getList(String filtro) throws SQLException{        
        String SQL="SELECT * FROM DISCIPLINAS WHERE NOME LIKE ? ORDER BY NOME";
        ResultSet rs = super.executeQuery(SQL,"%"+filtro.toUpperCase()+"%");
        List<Disciplina> retorno = new LinkedList<>();
        while (rs.next()){
            retorno.add(this.createObject(rs));
        }
        return retorno;         
    }
    //
    private Disciplina createObject(ResultSet rs) throws SQLException{    
        return new Disciplina(
                rs.getInt("ID"), 
                rs.getString("NOME"), 
                rs.getInt("CREDITO"), 
                rs.getBoolean("SEMIPRESENCIAL"), 
                new daoCurso().retrieve(rs.getInt("ID_CURSO")), 
                new daoProfessor().retrieve(rs.getInt("ID_PROFESSOR"))
        );
    }     
}
