/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import Classes.Curso;
import Classes.Disciplina;
import Classes.Professor;
import Enums.TipoSexo;
import Enums.TipoTitulacao;
import Enums.TipoTurno;

/**
 *
 * @author Personal
 */
public class Teste {
    public static void main(String[] args) {
        
        Professor p1 = new Professor("joao", TipoSexo.M, 10, 200, TipoTitulacao.GRAD);
        Professor p2 = new Professor("maria", TipoSexo.F, 10, 200, TipoTitulacao.GRAD);
        Professor p3 = new Professor("pedro", TipoSexo.M, 10, 200, TipoTitulacao.GRAD);
        
        Abstratas.Listas.getListaProfessor().add(p1);
        Abstratas.Listas.getListaProfessor().add(p2);
        Abstratas.Listas.getListaProfessor().add(p3);
        //
        Curso c1 = new Curso("SI", 300, p1, TipoTurno.N);
        Curso c2 = new Curso("adm", 300, p2, TipoTurno.N);
        
        Abstratas.Listas.getListaCurso().add(c1);
        Abstratas.Listas.getListaCurso().add(c2);
        //
        Disciplina d1 = new Disciplina("estrutura",p1,c1,false,4);
        Disciplina d2 = new Disciplina("algoritmos",p2,c1,false,4);
        Disciplina d3 = new Disciplina("banco",p3,c1,false,4);
        
        Abstratas.Listas.getListaDisciplina().add(d1);
        Abstratas.Listas.getListaDisciplina().add(d2);
        Abstratas.Listas.getListaDisciplina().add(d3);
                        
        for (Professor object : Abstratas.Listas.getListaProfessor()) {
            System.out.println(object.getNome()+"\t"+object.getSalario());
        }
        for (Curso object : Abstratas.Listas.getListaCurso()) {
            System.out.println(object.getNome()+"\t"+object.getCoordenador());
        }
        for (Disciplina object : Abstratas.Listas.getListaDisciplina()) {
            System.out.println(object.getNome()+"\t"+object.getCurso());
        }
        
    }    
    
}
