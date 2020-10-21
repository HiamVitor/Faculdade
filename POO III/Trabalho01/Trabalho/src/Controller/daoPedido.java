package Controller;

import Model.Pedido;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class daoPedido extends dao {

    public int create(Pedido pedido) throws SQLException {
        String SQL = "INSERT INTO pedido( precoTotal, id_vendedor, id_pedidoItem, id_cliente) VALUES ( ?, ?, ?, ?)";
        return super.executeUpdate(SQL,
                pedido.getPrecoTotal(),
                pedido.getVendedor().getId(),
                pedido.getPedidoItem().getId(),
                pedido.getCliente().getId());
    }

    public int update(Pedido pedido) throws SQLException {
        String SQL = "UPDATE pedido SET , precoTotal=?, getVendedor=?, id_pedidoItem=?, id_professor=? WHERE id=?";
        return super.executeUpdate(SQL,
                pedido.getPrecoTotal(),
                pedido.getVendedor().getId(),
                pedido.getPedidoItem().getId(),
                pedido.getCliente().getId(),
                pedido.getId()
        );
    }

    public int delete(Pedido pedido) throws SQLException {
        return super.executeUpdate("delete from pedido where id=" + pedido.getId());
    }

    //
    public Pedido retrieve(int id) throws SQLException {
        String SQL = "SELECT * FROM DISCIPLINAS WHERE ID=" + id;
        ResultSet rs = super.executeQuery(SQL);
        return (rs.next() ? this.createObject(rs) : null);
    }

    public List<Pedido> getList() throws SQLException {
        String SQL = "SELECT * FROM DISCIPLINAS ORDER BY NOME";
        ResultSet rs = super.executeQuery(SQL);
        List<Pedido> retorno = new LinkedList<>();
        while (rs.next()) {
            retorno.add(this.createObject(rs));
        }
        return retorno;
    }

    public List<Pedido> getList(String filtro) throws SQLException {
        String SQL = "SELECT * FROM DISCIPLINAS WHERE NOME LIKE ? ORDER BY NOME";
        ResultSet rs = super.executeQuery(SQL, "%" + filtro.toUpperCase() + "%");
        List<Pedido> retorno = new LinkedList<>();
        while (rs.next()) {
            retorno.add(this.createObject(rs));
        }
        return retorno;
    }

    //
    private Pedido createObject(ResultSet rs) throws SQLException {
        return new Pedido(
                rs.getInt("ID"),
                rs.getDouble("PRECOTOTAL"),
                new daoVendedor().retrieve(rs.getInt("ID_VENDEDOR")),
                new daoPedidoItem().retrieve(rs.getInt("id_pedidoItem")),
                new daoCliente().retrieve(rs.getInt("ID_CLIENTE"))
        );
    }
}
