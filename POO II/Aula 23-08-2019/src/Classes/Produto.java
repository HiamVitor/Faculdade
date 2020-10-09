
package Classes;

import Abstratas.Dados;
import Enums.Unidades;
import java.util.LinkedList;
import java.util.List;

public class Produto extends Dados{
    private Unidades unidade;
    private double estoque;
    private double custo;
    private double venda;
    private List<Fornecedor> fornecedor;
    //
    public Produto(){
        super();
        this.setUnidade(Unidades.UND);
        this.setEstoque(0);
        this.setCusto(0);
        this.setVenda(0);
        this.fornecedor = new LinkedList<>();
    }
    public Produto(String nome,Unidades unidade,double estoque,
            double custo, double venda){
        super(nome);
        this.setUnidade(unidade);
        this.setEstoque(estoque);
        this.setCusto(custo);
        this.setVenda(venda);
        this.fornecedor = new LinkedList<>();
    }
    //
    public void setUnidade(Unidades unidade){
        this.unidade = unidade==null?Unidades.CX : unidade;
    }
    public void setEstoque(double estoque){
        this.estoque = estoque < 0 ? 0 : estoque;
    }
    public void setCusto(double custo){
        this.custo = custo < 0 ? 0 : custo;
    }    
    public void setVenda(double venda){
        this.venda = venda < 0 ? 0.01 : venda;
    }
    //
    public Unidades getUnidade(){
        return this.unidade;
    }
    public double getEstoque(){
        return this.estoque;
    }
    public double getCusto(){
        return this.custo;
    }
    public double getVenda(){
        return this.venda;
    }
    public List<Fornecedor> getList(){
        return this.fornecedor;
    }
}
