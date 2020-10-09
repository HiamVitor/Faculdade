
package Classes;

import Abstratas.Dados;

public class Disciplina extends Dados{
    private Professor professor;
    private Curso curso;
    private boolean semiPresencial;
    private int credito;
    //
    public Disciplina(){
        super();
        this.setProfessor(null);
        this.setCurso(null);
        this.setSemiPresencial(false);
        this.setCreditos(0);
    }
    public Disciplina(String nome,Professor professor,
            Curso curso, boolean semi, int creditos){
        super(nome);
        this.setProfessor(professor);
        this.setCurso(curso);
        this.setSemiPresencial(semi);
        this.setCreditos(creditos);
    }
    //
    public void setProfessor(Professor professor){
        this.professor=professor==null?
                new Professor() : professor;
    }
    public void setCurso(Curso curso){
        this.curso=curso==null?new Curso():curso;
    }
    public void setSemiPresencial(boolean semi){
        this.semiPresencial = semi;
    }
    public void setCreditos(int creditos){
        this.credito = creditos <= 0 ? 1 : creditos;
    }

    public Professor getProfessor() {
        return this.professor;
    }

    public Curso getCurso() {
        return this.curso;
    }

    public boolean isSemiPresencial() {
        return this.semiPresencial;
    }

    public int getCredito() {
        return this.credito;
    }
    
}
