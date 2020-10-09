
package Classes;

import Abstratas.Listas;
import Abstratas.Base;
import java.util.Date;

public class Servicos extends Base{
    private double qtHoras;
    private Date data;
    private Cliente cliente;
            
    //
    public Servicos(){
        super();
        this.setQtHoras(0);
        this.setData(new Date());
        this.setCliente(null);
    }
    //
    public Servicos(String nome, double qtHoras, Cliente cliente){
        super(nome);
        this.setQtHoras(qtHoras);
        this.setData(new Date());
        this.setCliente(cliente);
    }
    //
    public void setQtHoras(double qtHoras) {
        this.qtHoras = qtHoras;
    }
        public void setData(Date data) {
        this.data = data;
    }
     public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    //
    public double getQtHoras() {
        return qtHoras;
    }
    public Date getData() {
        return this.data;
    }
    public Cliente getCliente() {
        return cliente;
    }
    //
    @Override
    public double getValorFatura(){
        return (this.qtHoras * Listas.getValorHoraServico());
    }
    //
    @Override
    public String getTipo(){
        return "SERVIÇO";
    }
}
