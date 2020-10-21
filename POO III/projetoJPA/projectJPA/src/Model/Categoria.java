
package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CATEGORIAS")

public class Categoria implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID",nullable = false)
    private int id;
    @Column(name = "NOME",length = 100,nullable = false)
    private String nome;
    @Column(name = "VALOR",nullable = false,scale = 2)
    private double valor;
    //
    public Categoria() {}
    
    public Categoria(int id,String nome,double valor){
        this.setId(id);
        this.setNome(nome);
        this.setValor(valor);
    }
    //
    public void setId(int id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome.trim().isEmpty() ? "NOME PADRÃO" : nome.toUpperCase();
    }
    public void setValor(double valor) {
        this.valor = valor <=0 ? 0.01 : valor;
    }
    //
    public int getId() {
        return this.id;
    }
    public String getNome() {
        return this.nome;
    }
    public double getValor() {
        return this.valor;
    }
    //
    @Override
    public String toString(){
        return this.nome;
    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.id;
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
        final Categoria other = (Categoria) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}
