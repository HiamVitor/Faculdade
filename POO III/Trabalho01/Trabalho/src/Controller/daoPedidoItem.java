package Controller;

import Model.PedidoItem;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class daoPedidoItem extends dao {

    public int create(PedidoItem curso) throws SQLException {
        String SQL = "INSERT INTO cursos(nome, preco) VALUES (?,?)";
        return super.executeUpdate(SQL,
                curso.getNome(),
                curso.getPreco());
    }

    public int update(PedidoItem curso) throws SQLException {
        String SQL = "UPDATE cursos SET nome=?, preco=? WHERE id=?";
        return super.executeUpdate(SQL,
                curso.getNome(),
                curso.getPreco(),
                curso.getId());
    }

    public int delete(PedidoItem curso) throws SQLException {
        return super.executeUpdate("delete from cursos where id=" + curso.getId());
    }

    //
    public PedidoItem retrieve(int id) throws SQLException {
        String SQL = "SELECT * FROM CURSOS WHERE ID=" + id;
        ResultSet rs = super.executeQuery(SQL);
        return (rs.next() ? this.createObject(rs) : null);
    }

    public List<PedidoItem> getList() throws SQLException {
        String SQL = "SELECT * FROM CURSOS ORDER BY NOME";
        ResultSet rs = super.executeQuery(SQL);
        List<PedidoItem> retorno = new LinkedList<>();
        while (rs.next()) {
            retorno.add(this.createObject(rs));
        }
        return retorno;
    }

    public List<PedidoItem> getList(String filtro) throws SQLException {
        String SQL = "SELECT * FROM CURSOS WHERE NOME LIKE ? ORDER BY NOME";
        ResultSet rs = super.executeQuery(SQL, "%" + filtro.toUpperCase() + "%");
        List<PedidoItem> retorno = new LinkedList<>();
        while (rs.next()) {
            retorno.add(this.createObject(rs));
        }
        return retorno;
    }

    //
    private PedidoItem createObject(ResultSet rs) throws SQLException {
        return (new PedidoItem(
                rs.getInt("ID"),
                rs.getString("NOME"),
                rs.getFloat("PRECO")
        ));
    }
}
