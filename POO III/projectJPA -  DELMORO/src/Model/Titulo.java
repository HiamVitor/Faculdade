
package Model;

import Enums.Tipos;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TITULOS")

public class Titulo implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID",nullable = false)
    private int id;
    //
    @Column(name = "NOME",nullable = false,length = 100)
    private String nome;
    //
    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO",nullable = false)
    private Tipos tipo;
    //
    @Column(name = "SINOPSE",nullable = true)
    private String sinopse;
    //
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_CATEGORIA",nullable = false, referencedColumnName = "ID")
    private Categoria categoria;
    //
    public Titulo(){
        
    }
    public Titulo(int id,String nome,Tipos tipo,String sinopse,Categoria categoria){
        this.setId(id);
        this.setNome(nome);
        this.setTipo(tipo);
        this.setSinopse(sinopse);
        this.setCategoria(categoria);
    }
    //
    public void setId(int id){
        this.id = id;
    }
    public void setNome(String nome){
        this.nome = nome.trim().isEmpty()?"NOME PADRÃO":nome.toUpperCase();
    }
    public void setTipo(Tipos tipo) {
        this.tipo = tipo;
    }
    public void setSinopse(String sinopse) {
        this.sinopse = sinopse.toUpperCase();
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    //
    public int getId() {
        return this.id;
    }
    public String getNome() {
        return this.nome;
    }
    public Tipos getTipo() {
        return this.tipo;
    }
    public String getSinopse() {
        return this.sinopse;
    }
    public Categoria getCategoria() {
        return this.categoria;
    }
    //
    @Override
    public String toString(){
        return this.nome;
    }
    //
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.id;
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
        final Titulo other = (Titulo) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}
