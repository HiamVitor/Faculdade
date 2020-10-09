package Classes;

import Abstratas.Funcionario;

public class Mensalista extends Funcionario{
    //especializados
    protected double salario;
    //
    public Mensalista(){
        super();
        this.setSalario(0);
    }
    public Mensalista(String nome, String cpf, int idade,double salario){
        super(nome, cpf, idade);
        this.setSalario(salario);
    }
    //set
    public void setSalario(double salario){
        this.salario =  salario <=0?0.01 : salario;
    }
    //get
    public double getSalario(){
        return this.salario;
    }
    
    
}
