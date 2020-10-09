
package Classes;

import Abstratas.Dados;
import Abstratas.Item;

public class Servico extends Item{
    private double numeroHoras;
    //
    public Servico(){
        super();
        this.setNumeroHoras(0);
    }
    public Servico(String nome, double numeroHoras){
        super(nome);
        this.setNumeroHoras(numeroHoras);
    }
    //
    public void setNumeroHoras(double numeroHoras){
        this.numeroHoras = numeroHoras < 0 ? 0.01 : numeroHoras;
    }
    //
    public double getNumeroHoras(){
        return this.numeroHoras;
    }
    //implementar método da interface
    @Override
    public double getValorFatura(){
        return (this.numeroHoras * Dados.getValorHoraServico());
    }
    @Override
    public String getTipo(){
        return "SERVIÇO";
    }
}
