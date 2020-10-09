package Classes;

import Abstratas.Pessoa;

public class Juridica  extends Pessoa{
//Especializados
    private String cnpj;
//
    public Juridica(){
        super();
        this.setCnpj("");
    }
    public Juridica(String nome,String endereco,String telefone,String cnpj){
        super(nome, endereco, telefone);
        this.setCnpj(cnpj);
    }
    //
    public void setCnpj(String cpf){
        this.cnpj = cnpj.trim().isEmpty()?"000.000.000/0000-00":cnpj;
    }
    public String getCnpj(){
        return this.cnpj;
    }    
}
