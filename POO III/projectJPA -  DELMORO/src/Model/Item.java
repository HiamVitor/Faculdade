
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

public class Item implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID",nullable = false)
    @SwingColumn(description = "Código")
    private int id;
    //
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_LOCACAO",nullable = false,referencedColumnName = "ID")
    @SwingColumn(description = "Locacao")
    private Locacao locacao;
    //
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_TITULO",nullable = false,referencedColumnName = "ID")
    @SwingColumn(description = "Titulo")
    private Titulo titulo;
    //
    @Column(name = "DEVOLVIDO", nullable = false)
    private boolean devolvido;
    //
    public Item(){
    }
    public Item(int id,Locacao locacao,Titulo titulo,boolean devolvido){
        this.setId(id);
        this.setLocacao(locacao);
        this.setTitulo(titulo);
        this.setDevolvido(devolvido);
    }
    //
    public void setId(int id) {
        this.id = id;
    }
    public void setLocacao(Locacao locacao) {
        this.locacao = locacao;
    }
    public void setTitulo(Titulo titulo) {
        this.titulo = titulo;
    }
    public void setDevolvido(boolean devolvido) {
        this.devolvido = devolvido;
    }
    //
    public int getId() {
        return this.id;
    }
    public Locacao getLocacao() {
        return this.locacao;
    }
    public Titulo getTitulo() {
        return this.titulo;
    }
    public boolean isDevolvido() {
        return this.devolvido;
    }
    //
    @Override
    public String toString(){
        return "(" + this.locacao + ") " + this.titulo;
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
