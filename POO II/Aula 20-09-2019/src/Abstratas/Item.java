
package Abstratas;

import Interfaces.AcaoFatura;

abstract public class Item implements AcaoFatura{
    private String nome;
    //
    public Item(){
        this.setNome("padrão");
    }
    public Item(String nome){
        this.setNome(nome);
    }
    //
    public void setNome(String nome){
        this.nome = nome.trim().isEmpty()?"PADRÃO":nome.toUpperCase();
    }
    //
    public String getNome(){
        return this.nome;
    }
    //
    @Override
    public String toString(){
        return this.nome;
    }
}
