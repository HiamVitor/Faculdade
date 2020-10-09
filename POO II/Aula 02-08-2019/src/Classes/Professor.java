
package Classes;

import Abstratas.Dados;
import Enums.TipoSexo;
import Enums.TipoTitulacao;

public class Professor extends Dados{
    //especializados
    private TipoSexo sexo;
    private int idade;
    private double salario;
    private TipoTitulacao titulacao;
    //
    public Professor(){
        super();
        this.setSexo(TipoSexo.M);
        this.setIdade(0);
        this.setSalario(0.01);
        this.setTitulacao(TipoTitulacao.GRAD);
    }
    public Professor(String nome,TipoSexo sexo,int idade,double salario,TipoTitulacao titulacao){
        super(nome);
        this.setSexo(sexo);
        this.setIdade(idade);
        this.setSalario(salario);
        this.setTitulacao(titulacao);        
    }
    //
    public void setSexo(TipoSexo sexo){
        this.sexo = sexo==null ? TipoSexo.M : sexo;
    }
    public void setIdade(int idade){
        this.idade = (idade < 0) || (idade > 150) ? 0 : idade;
    }
    public void setSalario(double salario){
        this.salario = salario < 0 ? 0.01 : salario;
    }
    public void setTitulacao(TipoTitulacao titulacao){
        this.titulacao = titulacao==null ? TipoTitulacao.GRAD : titulacao;
    }
    //
    public TipoSexo getSexo(){
        return this.sexo;
    }
    public int getIdade(){
        return this.idade;
    }
    public double getSalario(){
        return this.salario;
    }
    public TipoTitulacao getTitulacao(){
        return this.titulacao;
    }
}
