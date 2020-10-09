
package Model;

public class Disciplina implements java.io.Serializable{
    private int id;
    private String nome;
    private int credito;
    private boolean semiPresencial;
    private Curso curso;
    private Professor professor;
    //
    public Disciplina(){
        
    }
    public Disciplina(int id,String nome,int credito,boolean semiPresencial,Curso curso,Professor professor){
        this.setId(id);
        this.setNome(nome);
        this.setCredito(credito);
        this.setSemiPresencial(semiPresencial);
        this.setCurso(curso);
        this.setProfessor(professor);
    }
    //
    public void setId(int id){
        this.id = id;
    }
    public void setNome(String nome){
        this.nome = nome.trim().isEmpty() ? "NOME PADRÃO" : nome.toUpperCase();
    }
    public void setCredito(int credito){
        this.credito = (credito!=2)&&(credito!=4) ? 2 : credito;
    }
    public void setSemiPresencial(boolean semiPresencial){
        this.semiPresencial = semiPresencial;
    }
    public void setCurso(Curso curso){
        this.curso = curso;
    }
    public void setProfessor(Professor professor){
        this.professor = professor;
    }
    //
    public int getId() {
        return this.id;
    }
    public String getNome() {
        return this.nome;
    }
    public int getCredito() {
        return this.credito;
    }
    public boolean isSemiPresencial() {
        return this.semiPresencial;
    }
    public Curso getCurso() {
        return this.curso;
    }
    public Professor getProfessor() {
        return this.professor;
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
        hash = 79 * hash + this.id;
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
        final Disciplina other = (Disciplina) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }    
}
