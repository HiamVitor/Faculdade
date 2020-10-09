
package Classes;

import Abstratas.Item;
import Enums.Unidades;

public class Produto extends Item{
    private Unidades unidade;
    private double preco;
    //
    public Produto(){
        super();
        this.setUnidade(Unidades.PC);
        this.setPreco(0.01);
    }
    public Produto(String nome,Unidades unidade, double preco){
        super(nome);
        this.setUnidade(unidade);
        this.setPreco(preco);
    }
    //
    public void setUnidade(Unidades unidade){
        this.unidade=unidade==null?Unidades.PC : unidade;
    }
    public void setPreco(double preco){
        this.preco = preco <=0 ? 0.01 : preco;
    }
    //
    public Unidades getUnidade(){
        return this.unidade;
    }
    public double getPreco(){
        return this.preco;
    }
    //implementar método da interface
    @Override
    public double getValorFatura(){
        return this.preco;
    }
    public String getTipo(){
        return "PRODUTO";
    }
}
