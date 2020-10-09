
package Classes;

import Enum.Origem;

public class Servico extends Produto{
    public double tempoEstimado;

    public Servico(double tempoEstimado) {
        super();
        this.setTempoEstimado(0);
    }

    public Servico(double tempoEstimado, String nome, double vlvenda, double vlcusto, Origem origem) {
        super(nome, vlvenda, vlcusto, origem);
        this.setTempoEstimado(tempoEstimado);
    }

    public double getTempoEstimado(double tempoEstimado) {
        return tempoEstimado = (tempoEstimado);
    }

    public void setTempoEstimado(double tempoEstimado) {
        this.tempoEstimado = (tempoEstimado);
    }

    public String getNome() {
        return nome;
    }

    public double getVlvenda() {
        return vlvenda;
    }

    public double getVlcusto() {
        return vlcusto;
    }
    
    
    
}
