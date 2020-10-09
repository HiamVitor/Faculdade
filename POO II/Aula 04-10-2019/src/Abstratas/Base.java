
package Abstratas;

abstract public class Base {
    private String nome;
    private String cpf;
    //

    public Base() {
        this.setNome("padrão");
        this.setCpf("000.000.000-00");
    }
    public Base(String nome, String cpf) {
        this.setNome(nome);
        this.setCpf(cpf);
    }    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome.trim().isEmpty()?"PADRÃO":nome.toUpperCase();
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf.trim().isEmpty()?"000.000.000-00":cpf;
    }

    @Override
    public String toString() {
        return nome;
    }
    
}
