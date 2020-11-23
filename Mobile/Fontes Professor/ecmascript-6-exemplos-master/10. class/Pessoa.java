public class Pessoa {

    public String nome;
    public char sexo;
    public Date dataNascimento;

    public Pessoa() {}

    public Pessoa(nome, sexo, dataNascimento) {
        this.nome = nome;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
    }

    public String getInformacoes() {
        return "Nome: " + nome + "\nSexo: " + sexo + "\nData de Nascimento: " + dataNascimento.toString();
    }

    public int getIdadeAtual() {
        return new Date().getFullYear() - this.dataNascimento.getFullYear();
    }

    public static void imprimirIdade(Pessoa p) {
        System.out.println(p.getIdadeAtual())   
    }

}