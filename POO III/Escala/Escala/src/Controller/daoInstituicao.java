
package Controller;

import Model.Instituicao;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class daoInstituicao extends dao{
    public int create(Instituicao instituicao) throws SQLException{
        String SQL = "INSERT INTO instituicoes(razao, endereco, cnpj, id_cidade) VALUES (?, ?, ?, ?)";
        return super.executeUpdate(SQL, 
                instituicao.getRazao(),
                instituicao.getEndereco(),
                instituicao.getCnpj(),
                instituicao.getCidade().getId());
    }
    public int update(Instituicao instituicao) throws SQLException{
        String SQL="UPDATE instituicoes SET razao=?, endereco=?, cnpj=?, id_cidade=? WHERE id=?";
        return super.executeUpdate(SQL, 
                instituicao.getRazao(),
                instituicao.getEndereco(),
                instituicao.getCnpj(),
                instituicao.getCidade().getId(),
                instituicao.getId());        
    }
    public int delete(Instituicao instituicao) throws SQLException{
        String SQL="DELETE FROM instituicoes WHERE id="+instituicao.getId();
        return super.executeUpdate(SQL);
    }
    public Instituicao retrieve(int id) throws SQLException{
        String SQL="SELECT * FROM INSTITUICOES WHERE ID="+id;
        ResultSet rs = super.executeQuery(SQL);
        return (rs.next() ? createObject(rs) : null);
    }
    public List<Instituicao> getList() throws SQLException{
        String SQL="SELECT * FROM INSTITUICOES ORDER BY RAZAO";
        ResultSet rs = super.executeQuery(SQL);
        List<Instituicao> retorno = new LinkedList<>();
        while(rs.next()){
            retorno.add(createObject(rs));
        }
        return retorno;        
    }
    //
    public Instituicao createObject(ResultSet rs) throws SQLException{
        return new Instituicao(
                rs.getInt("ID"), 
                rs.getString("RAZAO"), 
                rs.getString("ENDERECO"),
                rs.getString("CNPJ"), 
                new daoCidade().retrieve(rs.getInt("ID_CIDADE"))
        );
    }
}
