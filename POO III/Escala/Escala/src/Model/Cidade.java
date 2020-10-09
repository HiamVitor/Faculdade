
package Model;

import enums.Estados;

public class Cidade implements java.io.Serializable{
    private int id;
    private String nome;
    private Estados estado;
    //
    public Cidade(){
        this.setId(0);
        this.setNome("cidade padrão");
        this.setEstado(Estados.SC);
    }
    public Cidade(int id,String nome,Estados estado){
        this.setId(id);
        this.setNome(nome);
        this.setEstado(estado);
    }
    //
    public void setId(int id){
        this.id = id;
    }
    public void setNome(String nome){
        this.nome = nome.trim().isEmpty() ? "NOME PADRÃO" : nome.toUpperCase();
    }
    public void setEstado(Estados estado){
        this.estado = estado;
    }
    //
    public int getId() {
        return this.id;
    }
    public String getNome() {
        return this.nome;
    }
    public Estados getEstado() {
        return this.estado;
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
        hash = 29 * hash + this.id;
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
        final Cidade other = (Cidade) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}
