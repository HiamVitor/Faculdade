
package Abstratas;

import Classes.Curso;
import Classes.Disciplina;
import Classes.Professor;
import java.util.LinkedList;

abstract public class Listas {
    private static LinkedList<Curso> listaCurso = new LinkedList<>();
    private static LinkedList<Professor> listaProfessor = new LinkedList<>();
    private static LinkedList<Disciplina> listaDisciplina = new LinkedList<>();
    
    public static LinkedList<Curso> getListaCurso(){
        return listaCurso;
    }
    public static LinkedList<Professor> getListaProfessor(){
        return listaProfessor;
    }
    public static LinkedList<Disciplina> getListaDisciplina(){
        return listaDisciplina;
    }
}
