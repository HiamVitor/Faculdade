
package Controller;

import Model.Professor;
import enums.Sexos;
import enums.Titulacoes;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.LinkedList;

public class daoProfessor extends dao{
    public int create(Professor professor) throws SQLException{
        String SQL="INSERT INTO professores(nome, nascimento, cpf, sexo, titulacao, id_instituicao) "
                 + "VALUES (?, ?, ?, ?, ?, ?)";
        return super.executeUpdate(SQL, 
                professor.getNome(),
                professor.getNascimento(),
                professor.getCpf(),
                professor.getSexo().name(),
                professor.getTitulacao().name(),
                professor.getInstituicao().getId()
                );        
    }
    public int update(Professor professor) throws SQLException{
        String SQL="UPDATE professores SET nome=?, nascimento=?, "
                 + "cpf=?, sexo=?, titulacao=?, id_instituicao=? "
                + "WHERE id=?";
        return super.executeUpdate(SQL, 
                professor.getNome(),
                professor.getNascimento(),
                professor.getCpf(),
                professor.getSexo().name(),
                professor.getTitulacao().name(),
                professor.getInstituicao().getId(),
                professor.getId()
                );
    }
    public int delete(Professor professor) throws SQLException{
        return super.executeUpdate("DELETE FROM PROFESSORES WHERE ID="+professor.getId());        
    }
    //
    public Professor retrieve(int id) throws SQLException{
        String SQL="SELECT * FROM PROFESSORES WHERE ID="+id;
        ResultSet rs = super.executeQuery(SQL);
        return (rs.next() ? createObject(rs) : null);        
    }
    public List<Professor> getList() throws SQLException{
        String SQL="SELECT * FROM PROFESSORES ORDER BY NOME";
        ResultSet rs = super.executeQuery(SQL);
        List<Professor> retorno = new LinkedList<>();
        while (rs.next()){
            retorno.add(createObject(rs));
        }
        return (retorno);        
    }
    public List<Professor> getList(String filtro) throws SQLException{
        String SQL="SELECT * FROM PROFESSORES WHERE NOME LIKE ? ORDER BY NOME";
        ResultSet rs = super.executeQuery(SQL,"%"+filtro.toUpperCase()+"%");
        List<Professor> retorno = new LinkedList<>();
        while (rs.next()){
            retorno.add(createObject(rs));
        }
        return (retorno);        
    }
    //
    private Professor createObject(ResultSet rs) throws SQLException{
        return new Professor(
                rs.getInt("ID"), 
                rs.getString("NOME"), 
                rs.getDate("NASCIMENTO").toLocalDate(), 
                rs.getString("CPF"), 
                Sexos.valueOf(rs.getString("SEXO")), 
                Titulacoes.valueOf(rs.getString("TITULACAO")), 
                new daoInstituicao().retrieve(rs.getInt("ID_INSTITUICAO"))
        );        
    }
}
