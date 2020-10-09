/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste.Classes;

public class Pessoa {
    private String nome;
    private int idade;
    private String profissao;
    //
    public Pessoa(){
        this.setNome("padrão");
        this.setIdade(0);
        this.setProfissao("padrão");
    }
    public Pessoa(String nome,int idade,String profissao){
        this.setNome(nome);
        this.setIdade(idade);
        this.setProfissao(profissao);
    }
    //
    public void setNome(String nome){
        this.nome=nome.trim().isEmpty()?"PADRÃO":nome.toUpperCase();
    }
    public void setIdade(int idade){
        this.idade=idade < 0 ? 0 : idade;
    }
    public void setProfissao(String profissao){
        this.profissao=profissao.trim().isEmpty()?"PADRÃO":profissao.toUpperCase();
    }
    //
    public String getNome(){
        return nome;
    }
    public int getIdade(){
        return this.idade;
    }
    public String getProfissao(){
        return this.profissao;
    }
    //
    @Override

    public String toString(){
        return this.nome;
    }
          
    
    
}
