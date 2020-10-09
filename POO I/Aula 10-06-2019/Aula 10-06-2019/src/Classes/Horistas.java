package Classes;

import Abstratas.Funcionario;

public class Horistas extends Funcionario {
    //especializados
    protected double numero;
    protected double valor;
    //
    public Horistas(){
        super();
        this.setNumero(0);
        this.setValor(0.01);
    }
    public Horistas(String nome,String cpf,int idade,double numero, double valor){
        super(nome, cpf, idade);
        this.setNumero(numero);
        this.setValor(valor);
    }
    //set
    public void setNumero(double numero){
        this.numero = numero < 0? 0 : numero;
    }
    public void setValor(double valor){
        this.valor = valor < 0? 0.01 : valor;
    }
    //get
     public double getNumero(){
         return this.numero;
     }
     public double getValor(){
         return this.valor;
     }
     public double getSalario(){
         return this.numero * this.valor;
     }
    
    
}
