
package Model;

import enums.Turnos;

public class Curso implements java.io.Serializable{
    private int id;
    private String nome;
    private Turnos turno;
    //
    public Curso(){
        
    }
    public Curso(int id,String nome,Turnos turno){
        this.setId(id);
        this.setNome(nome);
        this.setTurno(turno);
    }
    //
    public void setId(int id){
        this.id = id;
    }
    public void setNome(String nome){
        this.nome = nome.trim().isEmpty() ? "NOME PADRÃO" : nome.toUpperCase();
    }
    public void setTurno(Turnos turno){
        this.turno = turno;
    }
    //
    public int getId() {
        return this.id;
    }
    public String getNome() {
        return this.nome;
    }
    public Turnos getTurno() {
        return this.turno;
    }
    //
    @Override
    public String toString(){
        return this.nome + " ("+this.turno+")";
    }
    //
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id;
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
        final Curso other = (Curso) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
}
