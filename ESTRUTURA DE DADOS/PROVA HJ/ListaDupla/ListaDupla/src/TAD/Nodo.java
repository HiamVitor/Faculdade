package TAD;
public class Nodo {
    private int informacao;
    private Nodo anterior;
    private Nodo proximo;

    public Nodo() {
        this.setInformacao(0);
    }

    public Nodo(int informacao) {
        this.setInformacao(informacao);
    }

    public void setInformacao(int informacao) {
        this.informacao = informacao < 0 ? 0 : informacao;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

    public void setProximo(Nodo proximo) {
        this.proximo = proximo;
    }

    public int getInformacao() {
        return informacao;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public Nodo getProximo() {
        return proximo;
    }
    
    
    
    
    
}
