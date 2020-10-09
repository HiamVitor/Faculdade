
package Classes;

import Abstratas.Base;
import java.util.Date;

public class Cliente extends Base{
    private String endereco;
    private Date nascimento;
    //
    public Cliente() {
        super();
        this.setEndereco("padrão");
        this.setNascimento(new Date());
    }

    public Cliente(String nome, String cpf,String endereco, Date nascimento) {
        super(nome, cpf);
        this.setEndereco(endereco);
        this.setNascimento(nascimento);
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco.trim().isEmpty()?"PADRÃO":endereco.toUpperCase();
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento==null?new Date():nascimento;
    }    
    
}
