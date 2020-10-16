package Model;

import enums.Estados;
import enums.Sexos;
import java.time.LocalDate;

public class Cliente implements java.io.Serializable {

    private int id;
    private String nome;
    private LocalDate nascimento;
    private String cpf;
    private Sexos sexo;
    private Cidade cidade;

    //
    public Cliente() {

    }

    public Cliente(int id, String nome, LocalDate nascimento, String cpf, Sexos sexo, Cidade cidade) {
        this.setId(id);
        this.setNome(nome);
        this.setNascimento(nascimento);
        this.setCpf(cpf);
        this.setSexo(sexo);
        this.setCidade(cidade);
    }

    //
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome.trim().isEmpty() ? "NOME PADRÃO" : nome.toUpperCase();
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento == null ? LocalDate.now() : nascimento;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf.trim().isEmpty() ? "000.000.000-00" : cpf;
    }

    public void setSexo(Sexos sexo) {
        this.sexo = sexo;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade == null ? new Cidade(1, "", Estados.ES) : cidade;
    }

    //
    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public LocalDate getNascimento() {
        return this.nascimento;
    }

    public String getCpf() {
        return this.cpf;
    }

    public Sexos getSexo() {
        return this.sexo;
    }

    public Cidade getCidade() {
        return this.cidade;
    }

    //
    @Override
    public String toString() {
        return this.nome;
    }

    //
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}
