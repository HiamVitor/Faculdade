
package Abstratas;

public abstract class Dados {
    private String nome;
    //
    public Dados (){
        this.setNome("Padrão");
    }
    public Dados(String nome){
        this.setNome(nome);
    }
    //
    public void setNome(String nome){
       this.nome = nome.trim().isEmpty()? "PADRÃO" : nome.toUpperCase();
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
