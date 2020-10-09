package Classes;

import Abstratas.Pessoa;

public class Fisica extends Pessoa{
//Especializados
    private String cpf;
//
    public Fisica(){
        super();
        this.setCpf("");
    }
    public Fisica(String nome,String endereco,String telefone,String cpf){
        super(nome, endereco, telefone);
        this.setCpf(cpf);
    }
    //set
    public void setCpf(String cpf){
        this.cpf = cpf.trim().isEmpty()?"000.000.000-00":cpf;
    }
    //Get
    public String getCpf(){
        return this.cpf;
    }
    //
    @Override
    public String toString(){
        return this.getNome() + "-" + this.cpf;
    }
    
    
}
