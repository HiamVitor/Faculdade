
package Classes;

import Abstratas.Dados;

public class Produto extends Dados{
    //Especializados
    private double estoque;
    private double preco;
    //Construtor
    public  Produto(){
        super();
        this.setEstoque(0);
        this.setPreco(0);    
    }
    public Produto(String nome,double estoque, double preco){
        super(nome);
        this.setEstoque(estoque);
        this.setPreco(preco);
    }
    //
    public void setEstoque(double estoque){
        this.estoque = estoque < 0 ? 0 : estoque;
    }
    public void setPreco(double preco){
        this.preco = preco < 0 ? 0.01 : preco;
    }
    //
    public double getEstoque(){
        return this.estoque;
    }
    public double getPreco(){
        return this.preco;
    }
}


