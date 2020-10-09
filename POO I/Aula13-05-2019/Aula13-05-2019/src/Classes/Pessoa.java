
package Classes;


public class Pessoa {
    //atributos
    private String nome;
    private int idade;
    private char sexo;
    private String profissao;
    //métodos
    //construtor        
    //set
    public void setNome(String param){
        nome = param.trim().isEmpty()?"PADRÃO'":param.toUpperCase();
    }
    public void setIdade(int param){
        idade = (param<0) ||(param>150) ? 
    }
    public Pessoa(){
        nome = "padrão";
        idade= 0;
        sexo='M';
        profissao="padrão";
    }
    //get
    //is
    //toString
    
}
