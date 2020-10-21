package Controller;

import Model.Cliente;
import enums.Sexos;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class daoCliente extends dao {

    public int create(Cliente cliente) throws SQLException {
        String SQL = "INSERT INTO clientees(nome,endereco, nascimento, cpf, sexo, id_cidade) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        return super.executeUpdate(SQL,
                cliente.getNome(),
                cliente.getEndereco(),
                cliente.getNascimento(),
                cliente.getCpf(),
                cliente.getSexo().name(),
                cliente.getCidade().getId()
        );
    }

    public int update(Cliente cliente) throws SQLException {
        String SQL = "UPDATE clientees SET nome=?, endereco=? ,nascimento=?, "
                + "cpf=?, sexo=?, titulacao=?, id_cidade=? "
                + "WHERE id=?";
        return super.executeUpdate(SQL,
                cliente.getNome(),
                cliente.getEndereco(),
                cliente.getNascimento(),
                cliente.getCpf(),
                cliente.getSexo().name(),
                cliente.getCidade().getId(),
                cliente.getId()
        );
    }

    public int delete(Cliente cliente) throws SQLException {
        return super.executeUpdate("DELETE FROM CLIENTES WHERE ID=" + cliente.getId());
    }

    //
    public Cliente retrieve(int id) throws SQLException {
        String SQL = "SELECT * FROM CLIENTES WHERE ID=" + id;
        ResultSet rs = super.executeQuery(SQL);
        return (rs.next() ? createObject(rs) : null);
    }

    public List<Cliente> getList() throws SQLException {
        String SQL = "SELECT * FROM CLIENTES ORDER BY NOME";
        ResultSet rs = super.executeQuery(SQL);
        List<Cliente> retorno = new LinkedList<>();
        while (rs.next()) {
            retorno.add(createObject(rs));
        }
        return (retorno);
    }

    public List<Cliente> getList(String filtro) throws SQLException {
        String SQL = "SELECT * FROM CLIENTES WHERE NOME LIKE ? ORDER BY NOME";
        ResultSet rs = super.executeQuery(SQL, "%" + filtro.toUpperCase() + "%");
        List<Cliente> retorno = new LinkedList<>();
        while (rs.next()) {
            retorno.add(createObject(rs));
        }
        return (retorno);
    }

    //
    private Cliente createObject(ResultSet rs) throws SQLException {
        return new Cliente(
                rs.getInt("ID"),
                rs.getString("NOME"),
                rs.getString("ENDERECO"),
                rs.getDate("NASCIMENTO").toLocalDate(),
                rs.getString("CPF"),
                Sexos.valueOf(rs.getString("SEXO")),
                new daoCidade().retrieve(rs.getInt("ID_CIDADE"))
        );
    }
}
