
package Classes;

import Abstratas.Base;
import Enums.Unidades;

public class Produtos extends Base{
    //
    private Unidades unidade;
    private double preco;
    private Cliente cliente;
    //
    public Produtos(){
        super();
        this.setUnidade(Unidades.CO);
        this.setPreco(0.01);
        this.setCliente(null);
    }
    //
    public Produtos(String nome,Unidades unidade, double preco, Cliente cliente){
        super(nome);
        this.setUnidade(unidade);
        this.setPreco(preco);
        this.setCliente(cliente);
    }
    //
    public void setUnidade(Unidades unidade){
        this.unidade = unidade == null ? Unidades.CO : unidade;
    }
    public void setPreco(double preco){
        this.preco = preco <= 0 ? 0.01 : preco;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente == null ? new Cliente() : cliente;
    }
    //
    public Unidades getUnidade(){
        return this.unidade;
    }
    public double getPreco(){
        return this.preco;
    }
    public Cliente getCliente() {
        return cliente;
    }    
    //
    @Override
    public double getValorFatura(){
        return this.preco;
    }
    //
    public String getTipo(){
        return "PRODUTO";
    }    
}
