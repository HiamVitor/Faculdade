package Abstratas;

abstract public class Funcionario {

protected String nome;
protected String cpf;
protected int idade;
//
public Funcionario(){
    this.setNome("padrão");
    this.setCPF("000.000.000-00");
    this.setIdade(0);
}
public Funcionario(String nome, String cpf, int idade){
    this.setNome(nome);
    this.setCPF(cpf);
    this.setIdade(idade);    
}
 //
public void setNome(String nome){
    this.nome = nome.trim().isEmpty()?"PADRÃO":nome.toUpperCase();
}
public void setCPF(String cpf){
   this.cpf = cpf.trim().isEmpty()?"000.000.000-00":cpf; 
}
public void setIdade(int idade){
  this.idade = (idade < 0) || (idade>150)? 0 :idade  ;
}
//get
public String getNome(){
    return this.nome;
}
public String getCPF(){
    return this.cpf;
}
public int getIdade(){
    return this.idade;
}
//To String
@Override
public String toString(){
  return this.nome;  
}
}
