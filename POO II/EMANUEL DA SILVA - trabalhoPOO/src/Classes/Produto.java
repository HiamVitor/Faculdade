package Classes;

import Enum.Origem;
        
public class Produto {
    public String nome;
    public double vlvenda;
    public double vlcusto;
    private Origem origem;
    
    public Produto() {
        this.setNome("");
        this.setVlcusto(0.00);
        this.setVlvenda(0.00);
        this.setOrigem(Origem.NAC);
    }
    
    public Produto(String nome, double vlvenda, double vlcusto, Origem origem) {
        this.setNome(nome);
        this.setVlcusto(vlcusto);
        this.setVlvenda(vlvenda);
        this.setOrigem(origem);
    }

    
    public void setNome(String nome) {
        this.nome = nome;
    }


    public void setVlvenda(double vlvenda) {
        this.vlvenda = vlvenda;
    }


    public void setVlcusto(double vlcusto) {
        this.vlcusto = vlcusto;
    }

    public String getNome() {
        return this.nome;
    }
    
    public double getVlvenda() {
        return this.vlvenda;
    }
    
    public double getVlcusto() {
        return this.vlcusto;
    }
    public Origem getorigem() {
        return this.origem;
    }

    public void setOrigem(Origem origem) {
        this.origem = origem;
    }
}
    

