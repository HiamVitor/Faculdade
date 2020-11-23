package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PAGAMENTO")

public class Pagamento implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    @SwingColumn(description = "Código")
    private int id;
    //
    @Column(name = "NOME", nullable = false, length = 100)
    @SwingColumn(description = "Nome")
    private String nome;

    //
    public Pagamento() {

    }

    public Pagamento(int id, String nome) {
        this.setId(id);
        this.setNome(nome);
    }

    //
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome.trim().isEmpty() ? "DINHEIRO" : nome.toUpperCase();
    }

    //
    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    //
    public String toString() {
        return this.nome;
    }

    //
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pagamento other = (Pagamento) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}
