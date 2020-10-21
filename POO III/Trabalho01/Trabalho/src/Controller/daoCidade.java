package Controller;

import Model.Cidade;
import Model.Cidade;
import enums.Estados;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class daoCidade extends dao {

    public int create(Cidade cidade) throws SQLException {
        String SQL = "INSERT INTO CIDADES(NOME,ESTADO) VALUES (?,?)";
        return super.executeUpdate(SQL, cidade.getNome(), cidade.getEstado().name());
    }

    public int update(Cidade cidade) throws SQLException {
        String SQL = "UPDATE CIDADES SET NOME=?,ESTADO=? WHERE ID=?";
        return super.executeUpdate(SQL, cidade.getNome(), cidade.getEstado().name(), cidade.getId());
    }

    public int delete(Cidade cidade) throws SQLException {
        String SQL = "DELETE FROM CIDADES WHERE ID=" + cidade.getId();
        return super.executeUpdate(SQL);
    }

    public Cidade retrieve(int id) throws SQLException {
        String SQL = "SELECT * FROM CIDADES WHERE ID=" + id;
        ResultSet rs = super.executeQuery(SQL);
        return (rs.next() ? createObject(rs) : null);
    }
    
    public List<Cidade> getList() throws SQLException {
        String SQL = "SELECT * FROM CLIENTES ORDER BY NOME";
        ResultSet rs = super.executeQuery(SQL);
        List<Cidade> retorno = new LinkedList<>();
        while (rs.next()) {
            retorno.add(createObject(rs));
        }
        return (retorno);
    }

    public List<Cidade> getList(String filtro) throws SQLException {
        String SQL = "SELECT * FROM CLIENTES WHERE NOME LIKE ? ORDER BY NOME";
        ResultSet rs = super.executeQuery(SQL, "%" + filtro.toUpperCase() + "%");
        List<Cidade> retorno = new LinkedList<>();
        while (rs.next()) {
            retorno.add(createObject(rs));
        }
        return (retorno);
    }

    //transformar o conteúdo do ResultSet em um objeto
    private Cidade createObject(ResultSet rs) throws SQLException {
        return (new Cidade(
                rs.getInt("ID"),
                rs.getString("NOME"),
                Estados.valueOf(rs.getString("ESTADO"))));
    }
}
