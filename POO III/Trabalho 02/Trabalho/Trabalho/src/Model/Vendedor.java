package Model;

import Enums.Sexos;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "VENDEDORES")

public class Vendedor implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    @SwingColumn(description = "Código")
    private int id;
    //
    @Column(name = "NOME", length = 100, nullable = false)
    @SwingColumn(description = "Nome Cliente")
    private String nome;
    //
    @Column(name = "ENDERECO", length = 150, nullable = false)
    private String endereco;
    //
    @Temporal(TemporalType.DATE)
    @Column(name = "NASCIMENTO", nullable = false)
    private Date nascimento;
    //
    @Enumerated(EnumType.STRING)
    @Column(name = "SEXO", length = 1, nullable = false)
    @SwingColumn(description = "Sexo")
    private Sexos sexo;
    //
    @Column(name = "CPF", length = 15, nullable = false)
    private String cpf;
    //
    @Column(name = "TELEFONE", length = 15, nullable = false)
    @SwingColumn(description = "Telefone")
    private String telefone;
    //
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_CIDADE", nullable = false, referencedColumnName = "ID")
    @SwingColumn(description = "Cidade")
    private Cidade cidade;
    //
    @Column(name = "ATIVO", nullable = false)
    private boolean ativo;
    //

    public Vendedor() {
    }

    //
    public Vendedor(int id, String nome, String endereco, Date nascimento, Sexos sexo,
            String cpf, String telefone, Cidade cidade, boolean ativo) {
        this.setId(id);
        this.setNome(nome);
        this.setEndereco(endereco);
        this.setNascimento(nascimento);
        this.setSexo(sexo);
        this.setCpf(cpf);
        this.setTelefone(telefone);
        this.setCidade(cidade);
        this.setAtivo(ativo);
    }

    //
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome.trim().isEmpty() ? "NOME PADRÃO" : nome.toUpperCase();
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco.trim().isEmpty() ? "ENDEREÇO PADRÃO" : endereco.toUpperCase();
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public void setSexo(Sexos sexo) {
        this.sexo = sexo;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf.trim().isEmpty() ? "000.000.000-00" : cpf;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone.trim().isEmpty() ? "(00)00000-0000" : telefone;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    //
    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public Date getNascimento() {
        return this.nascimento;
    }

    public Sexos getSexo() {
        return this.sexo;
    }

    public String getCpf() {
        return this.cpf;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public Cidade getCidade() {
        return this.cidade;
    }

    public boolean isAtivo() {
        return this.ativo;
    }

    //
    @Override
    public String toString() {
        return nome;
    }

    //
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.id;
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
        final Vendedor other = (Vendedor) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}
