
package Model;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "LOCACOES")

public class Locacao implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    @SwingColumn(description = "Código")
    private int id;
    //
    @Temporal(TemporalType.DATE)
    @Column(name = "data", nullable = false)
    private Date data;
    //
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_CLIENTE", nullable = false, referencedColumnName = "ID")
    @SwingColumn(description = "Cliente")
    private Cliente cliente; 
    //
    @Column(name = "TOTAL", nullable = false, scale = 2)
    @SwingColumn(description = "Total")
    private double total;
    //
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "locacao")
    private List<Item> listItem;
    //
    public Locacao(){
        
    }
    public Locacao(int id,Date data,Cliente cliente,double total){
        this.setId(id);
        this.setData(data);
        this.setCliente(cliente);
        this.setTotal(total);
    }
    //
    public void setId(int id){
        this.id = id;
    }
    public void setData(Date data){
        this.data = data==null ? new Date() : data;
    }
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }
    public void setTotal(double total){
        this.total = total < 0 ? 0 : total;
    }
    //
    public int getId() {
        return this.id;
    }
    public Date getData() {
        return this.data;
    }
    public Cliente getCliente() {
        return this.cliente;
    }
    public double getTotal() {
        return this.total;
    }
    public List<Item> getListItem() {
        return listItem;
    }    
    //
    @Override
    public String toString(){
        return "(" + this.id + ") " + this.cliente;
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
        final Locacao other = (Locacao) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }    
}
