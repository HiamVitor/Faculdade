package Classes;

public class Vendedor {
    //Atributos    
    private String nome;
    private String telefone;
    private double comissao;
    //Construtores
    public Vendedor(){
       setNome("Padrão");
       setTelefone("(00)0000-0000");
       setComissao(0);
    } 
    public Vendedor(String nome, String telefone,double comissao){
      setNome(nome);
      setTelefone(telefone);
      setComissao(comissao);
    }
    //SET
    public void setNome (String param){
        nome = param.trim().isEmpty() ? "PADRÃO" : param.toUpperCase();
    }
    public void setTelefone(String param){
        telefone = param.trim().isEmpty()?"(00)0000-0000":param;
    }
    public void setComissao(double param){
        comissao = (param<0)||(param>100) ? 0 : param;
    }
    //GET
    public String getNome(){
       return nome;
    }
    public String getTelefone(){
        return telefone;
    }
    public double getComissao(){
        return comissao;
    }
    //TOSTRING
    @Override
    public String toString(){
        return nome;
    }
    
    
}
