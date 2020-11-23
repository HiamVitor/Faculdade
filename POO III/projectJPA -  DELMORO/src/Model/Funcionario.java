
package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FUNCIONARIOS")

public class Funcionario implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    @SwingColumn(description = "Código")
    private int id;
    //
    @Column(name = "NOME", nullable = false,length = 100)
    @SwingColumn(description = "Nome")    
    private String nome;
    //    
    @Column(name = "TELEFONE", nullable = false,length = 15)
    @SwingColumn(description = "Telefone")        
    private String telefone;
    //
    public Funcionario(){
        
    }
    public Funcionario(int id,String nome,String telefone){
        this.setId(id);
        this.setNome(nome);
        this.setTelefone(telefone);
    }
    //
    public void setId(int id){
        this.id = id;
    }
    public void setNome(String nome){
        this.nome = nome.trim().isEmpty() ? "NOME PADRÃO" : nome.toUpperCase();
    }
    public void setTelefone(String telefone){
        this.telefone = telefone.trim().isEmpty() ? "(00)00000-0000" : telefone;
    }
    //
    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public String getTelefone() {
        return this.telefone;
    }
    //
    public String toString(){
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
        final Funcionario other = (Funcionario) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}
