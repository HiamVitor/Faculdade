package Classes;

import java.util.Date;

public class Cliente {
    //
    private String nome;
    private Date data;
    private String endereco;
    private String cpf;
//
    public Cliente() {
        this.setNome("Padrão");
        this.setData(new Date());
        this.setEndereco("Padrão");
        this.setCpf("Padrão");
    }
    //
    public Cliente(String nome, Date data, String endereco, String cpf) {
        this.setNome(nome);
        this.setData(data);
        this.setEndereco(endereco);
        this.setCpf(cpf);
    }

    public void setNome(String nome) {
        this.nome = nome.trim().isEmpty() ?  "Padrão" : nome.toUpperCase();
    }

    public void setData(Date data) {
        this.data = data == null ? new Date() : data;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco.trim().isEmpty() ?  "Padrão" : endereco.toUpperCase();
    }

    public void setCpf(String cpf) {
        this.cpf = cpf.trim().isEmpty() ?  "Padrão" : cpf;
    }

    public String getNome() {
        return this.nome;
    }

    public Date getData() {
        return this.data;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public String getCpf() {
        return this.cpf;
    }

    @Override
    public String toString() {
        return this.nome;
    }
    

    
    
    
}
