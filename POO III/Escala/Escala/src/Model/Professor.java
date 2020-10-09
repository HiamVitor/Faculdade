
package Model;

import enums.Sexos;
import enums.Titulacoes;
import java.time.LocalDate;

public class Professor implements java.io.Serializable{
    private int id;
    private String nome;
    private LocalDate nascimento;
    private String cpf;
    private Sexos sexo;
    private Titulacoes titulacao;
    private Instituicao instituicao;
    //
    public Professor(){
        
    }
    public Professor(int id,String nome,LocalDate nascimento,String cpf,Sexos sexo,Titulacoes titulacao,Instituicao instituicao){
        this.setId(id);
        this.setNome(nome);
        this.setNascimento(nascimento);
        this.setCpf(cpf);
        this.setSexo(sexo);
        this.setTitulacao(titulacao);
        this.setInstituicao(instituicao);
    }
    //
    public void setId(int id){
        this.id = id;
    }
    public void setNome(String nome){
        this.nome = nome.trim().isEmpty() ? "NOME PADRÃO" : nome.toUpperCase();
    }
    public void setNascimento(LocalDate nascimento){
        this.nascimento = nascimento == null ? LocalDate.now() : nascimento;
    }
    public void setCpf(String cpf){
        this.cpf = cpf.trim().isEmpty() ? "000.000.000-00" : cpf;
    }
    public void setSexo(Sexos sexo){
        this.sexo = sexo;
    }
    public void setTitulacao(Titulacoes titulacao){
        this.titulacao = titulacao;
    }
    public void setInstituicao(Instituicao instituicao){
        this.instituicao = instituicao;
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
    public Titulacoes getTitulacao() {
        return this.titulacao;
    }
    public Instituicao getInstituicao() {
        return this.instituicao;
    }
    //
    @Override
    public String toString(){
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
        final Professor other = (Professor) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}
