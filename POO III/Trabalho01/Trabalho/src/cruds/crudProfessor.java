package cruds;

import Controller.daoCidade;
import Controller.daoCliente;
import Model.Cliente;
import enums.Sexos;
import java.sql.SQLException;
import java.time.LocalDate;

public class crudProfessor {

    public static void main(String[] args) {
        daoCliente dao = new daoCliente();
        //
        try {
            Cliente p1 = new Cliente(0,
                    "joaquim de souza",
                    LocalDate.now(),
                    "111.222.333-44",
                    Sexos.M,
                    new daoCidade().retrieve(1));
            System.out.println(dao.create(p1));
        } catch (SQLException ex) {
            System.out.println("ERRO:" + ex.getMessage());
        }
    }

}
