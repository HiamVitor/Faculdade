package Abstratas;
public abstract class Dados {
    //atributos
    private String nome;
    //construtores
    public Dados (){
        this.setNome("Padrão");
    }
    public Dados(String nome){
        this.setNome(nome);
    }
    //set's
    public void setNome(String nome){
       this.nome = nome.trim().isEmpty()? "PADRÃO" : nome.toUpperCase();
    }
    //get's
    public String getNome(){
        return this.nome;
    }
    //toString
    @Override
    public String toString(){
     return this.nome;
    }

    
}
