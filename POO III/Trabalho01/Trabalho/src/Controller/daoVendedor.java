package Controller;

import Model.Vendedor;
import enums.Sexos;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class daoVendedor extends dao {

    public int create(Vendedor vendedor) throws SQLException {
        String SQL = "INSERT INTO vendedores(nome, nascimento, cpf, sexo, id_cidade) "
                + "VALUES (?, ?, ?, ?, ?)";
        return super.executeUpdate(SQL,
                vendedor.getNome(),
                vendedor.getNascimento(),
                vendedor.getCpf(),
                vendedor.getSexo().name(),
                vendedor.getCidade().getId()
        );
    }

    public int update(Vendedor vendedor) throws SQLException {
        String SQL = "UPDATE vendedores SET nome=?, nascimento=?, "
                + "cpf=?, sexo=?, id_cidade=? "
                + "WHERE id=?";
        return super.executeUpdate(SQL,
                vendedor.getNome(),
                vendedor.getNascimento(),
                vendedor.getCpf(),
                vendedor.getSexo().name(),
                vendedor.getCidade().getId(),
                vendedor.getId()
        );
    }

    public int delete(Vendedor vendedor) throws SQLException {
        return super.executeUpdate("DELETE FROM CLIENTES WHERE ID=" + vendedor.getId());
    }

    //
    public Vendedor retrieve(int id) throws SQLException {
        String SQL = "SELECT * FROM CLIENTES WHERE ID=" + id;
        ResultSet rs = super.executeQuery(SQL);
        return (rs.next() ? createObject(rs) : null);
    }

    public List<Vendedor> getList() throws SQLException {
        String SQL = "SELECT * FROM CLIENTES ORDER BY NOME";
        ResultSet rs = super.executeQuery(SQL);
        List<Vendedor> retorno = new LinkedList<>();
        while (rs.next()) {
            retorno.add(createObject(rs));
        }
        return (retorno);
    }

    public List<Vendedor> getList(String filtro) throws SQLException {
        String SQL = "SELECT * FROM CLIENTES WHERE NOME LIKE ? ORDER BY NOME";
        ResultSet rs = super.executeQuery(SQL, "%" + filtro.toUpperCase() + "%");
        List<Vendedor> retorno = new LinkedList<>();
        while (rs.next()) {
            retorno.add(createObject(rs));
        }
        return (retorno);
    }

    //
    private Vendedor createObject(ResultSet rs) throws SQLException {
        return new Vendedor(
                rs.getInt("ID"),
                rs.getString("NOME"),
                rs.getDate("NASCIMENTO").toLocalDate(),
                rs.getString("CPF"),
                Sexos.valueOf(rs.getString("SEXO")),
                new daoCidade().retrieve(rs.getInt("ID_CIDADE"))
        );
    }
}
