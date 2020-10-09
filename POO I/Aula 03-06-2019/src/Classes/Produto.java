package Classes;
public class Produto {
    //ATRIBUTOS
    private String nome;
    private double custo;    
    //CONTRUTOR 
    public Produto(){
        setNome("Padrão");
        setCusto(0);
    }
    public Produto(String nome, double custo){
        setNome(nome);
        setCusto(custo);
    }
    //SET
    public void setNome(String param){
        nome = param.trim().isEmpty() ? "PADRÃO" : param.toUpperCase();
    }
    public void setCusto(double param){
        custo = param < 0 ? 0.01 : param;
    }   
    //GET
    public String getNome(){
        return nome;
    }
    public double getCusto(){
        return custo;
    }
    //toString
    @Override
    public String toString(){
        return nome;
    }
}
