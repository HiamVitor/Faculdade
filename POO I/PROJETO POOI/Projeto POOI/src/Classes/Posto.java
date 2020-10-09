package Classes;

import Abstratas.Dados;

public class Posto extends Dados{
//atributos
    private String endereco;
    private String local;
    //Construtores
    public Posto(){
        super();
        this.setLocal("");
        this.setEndereco("");        
        }
    public Posto (String nome, String local, String endereco){
        super(nome);        
        this.setLocal(local);
        this.setEndereco(endereco);
    }       
    //Set's
    public void setLocal(String local){
        this.local = local.trim().isEmpty()?"POSTO IPIRANGA":local.toUpperCase();
    }
    public void setEndereco(String endereco){
        this.endereco = endereco.trim().isEmpty()?"ENDERECO PADRÃO":endereco.toUpperCase();
    }    
    //Get's
    public String getLocal(){
        return this.local;
    }  
    public String getEndereco(){
        return this.endereco;
    }
    
}
