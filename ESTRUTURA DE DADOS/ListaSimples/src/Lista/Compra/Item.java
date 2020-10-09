
package Lista.Compra;

public class Item {
    private String nome;
    private double quantidade;
    private double peso;
    
    //
    public Item(){
        this.setNome("padrão");
        this.setQuantidade(0);
        this.setPeso(0);
    }
    public Item(String nome,double quantidade,double peso){
        this.setNome(nome);
        this.setQuantidade(quantidade);
        this.setPeso(peso);
    }
    //
    public void setNome(String nome){
        this.nome=nome.trim().isEmpty()?"PADRÃO":nome.toUpperCase();
    }
    public void setQuantidade(double quantidade){
        this.quantidade=quantidade<0 ? 0 : quantidade;
    }
    public void setPeso(double peso){
        this.peso = peso <=0 ? 0.01 :peso;
    }
    //
    public String getNome(){
        return this.nome;
    }
    public double getQuantidade(){
        return this.quantidade;
    }
    public double getPeso(){
        return this.peso;
    }
    //
    public String toString(){
        return this.nome;
    }
    
}
