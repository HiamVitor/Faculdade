package Lista.Compra;

public class Nodo {
    private Item informacao;
    private Nodo proximo;
    //
    public Nodo(Item informacao){
        this.setInformacao(informacao);
    }
    //
    public void setInformacao(Item informacao){
        this.informacao=informacao==null ? new Item():informacao;
    }
    //
    public Item getInformacao(){
        return this.informacao;
    }
    public void setProximo(Nodo proximo){
        this.proximo = proximo;
    }
    public Nodo getProximo(){
        return this.proximo;
    }
}
