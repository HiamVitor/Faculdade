package Model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ITENSVEICULOS")

public class ItensVeiculo implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    @SwingColumn(description = "Código")
    private int id;
    //
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_VEICULO", nullable = false, referencedColumnName = "ID")
    @SwingColumn(description = "Veiculo")
    private Veiculo veiculo;
    //
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itensVeiculo")
    private List<Item> listItem;

    //
    public ItensVeiculo() {

    }

    public ItensVeiculo(int id, Veiculo veiculo) {
        this.setId(id);
        this.setVeiculo(veiculo);
    }

    //
    public void setId(int id) {
        this.id = id;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    //
    public int getId() {
        return this.id;
    }

    public Veiculo getVeiculo() {
        return this.veiculo;
    }

    public List<Item> getListItem() {
        return listItem;
    }

    //
    @Override
    public String toString() {
        return "(" + this.id + ") " + this.veiculo;
    }

    //
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.id;
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
        final ItensVeiculo other = (ItensVeiculo) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}
