package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ITENS")

public class Item implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private int id;
    //
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_ITENSVEICULO", nullable = false, referencedColumnName = "ID")
    private ItensVeiculo itensVeiculo;
    //
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_ACESSORIO", nullable = false, referencedColumnName = "ID")
    @SwingColumn(description = "Acessorio")
    private Acessorio acessorio;

    //
    public Item() {
    }

    public Item(int id, ItensVeiculo itensVeiculo, Acessorio acessorio) {
        this.setId(id);
        this.setItensVeiculo(itensVeiculo);
        this.setAcessorio(acessorio);
    }

    //
    public void setId(int id) {
        this.id = id;
    }

    public void setItensVeiculo(ItensVeiculo itensVeiculo) {
        this.itensVeiculo = itensVeiculo;
    }

    public void setAcessorio(Acessorio acessorio) {
        this.acessorio = acessorio;
    }

    //
    public int getId() {
        return this.id;
    }

    public Acessorio getAcessorio() {
        return this.acessorio;
    }

    public ItensVeiculo getItensVeiculo() {
        return this.itensVeiculo;
    }

    //
    @Override
    public String toString() {
        return "(" + this.acessorio + ") " + this.itensVeiculo;
    }

    //
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.id;
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
        final Item other = (Item) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}
