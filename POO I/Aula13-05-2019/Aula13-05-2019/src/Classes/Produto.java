package Classes;
public class Produto {
//atributos
private String nome;    
private String unidade;
private double custo;
private double venda;
//contrutores
public Produto(){
  setNome("Produto Padrão");
  setUnidade("UND");
  setCusto(0.01);
  setVenda(0.01);  
}
public Produto(String nome, String unidade, double custo, double venda){
  setNome(nome);
  setUnidade(unidade);
  setCusto(custo);
  setVenda(venda);
}
//set - atribuição
public void setNome(String param){
    nome = param.trim().isEmpty()?"PADRÃO":param.toUpperCase();
}
public void setUnidade(String param){
    unidade = param.trim().isEmpty()?"PADRÃO":param.toUpperCase();
}
public void setCusto(double param){
    custo = param < 0 ? 0 : param;
}
public void setVenda(double param){
    venda = param <= 0 ? 0.01 : param;
}
//get - Retorno
public String getNome(){
    return nome;
}
public String getUnidade(){
    return unidade;
}
public double getCusto(){
    return custo;
}
public double getVenda(){
    return venda;
}
//toString
@Override
public String toString(){
return nome + "\t" + venda;    
}
}
