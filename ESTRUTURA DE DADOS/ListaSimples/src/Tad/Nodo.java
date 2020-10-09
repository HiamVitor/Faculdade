
package Tad;

public class Nodo {
    private String informacao;
    private Nodo proximo;
    //
    public Nodo(String informacao){
        this.setInformacao(informacao);
    }
    //
    public void setInformacao(String informacao){
        this.informacao=informacao.trim().isEmpty()?"VAZIO":informacao.toUpperCase();
    }
    //
    public String getInformacao(){
        return this.informacao;
    }
    public void setProximo(Nodo proximo){
        this.proximo = proximo;
    }
    public Nodo getProximo(){
        return this.proximo;
    }
}
