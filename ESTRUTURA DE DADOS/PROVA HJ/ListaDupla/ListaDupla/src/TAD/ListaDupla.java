package TAD;
public class ListaDupla {
    private Nodo primeiro;
    private Nodo ultimo;
//

    public ListaDupla() {
        this.iniciaLista();
    }
//
    public Nodo getPrimeiro(){
        return this.primeiro;
    }
    public Nodo getUltimo(){
        return this.ultimo;
    }
    public void iniciaLista(){
        this.primeiro = null;
        this.ultimo = null;
    }
//
    public boolean estaVazia(){
    return(this.primeiro == null );
    }
//
public Nodo getNodo(int busca){
//busca do ultimo para o primeiro
    Nodo retorno = this.ultimo;
    while((retorno != null) && (retorno.getInformacao() != busca)){
        retorno = retorno.getAnterior();    }
    return retorno;
//busca do primeiro para o ultimo
    /*Nodo retorno = this.primeiro;
    while((retorno != null) && (retorno.getInformacao() != busca)){
        retorno = retorno.getProximo();
    }
    return retorno;*/
    }   
//incluir no final
    public  void incluirFinal(Nodo novo){
        if (this.estaVazia()){
            this.primeiro = this.ultimo = novo;
            novo.setAnterior(null);
            novo.setProximo(null);
            return;
        }
        novo.setProximo(null);
        novo.setAnterior(this.ultimo);
        this.ultimo.setProximo(novo);
        this.ultimo = novo;
    }
//incluir inicio
    public void incluirInicio(Nodo novo){
        if (this.estaVazia()){
         this.primeiro = this.ultimo = novo;
            novo.setAnterior(null);
            novo.setProximo(null);
            return;   
        }
        novo.setAnterior(null);
        novo.setProximo(this.primeiro);
        this.primeiro.setAnterior(novo);
        this.ultimo = novo;        
    }
//incluir Ordenado
    public void incluirOrdenado(Nodo novo){
        if (this.estaVazia()){
         this.incluirFinal(novo);
            return;   
        }
        if (novo.getInformacao() <= this.getPrimeiro().getInformacao()){
            incluirInicio(novo);
            return;
        }
        if (novo.getInformacao() >= this.getUltimo().getInformacao()){
            incluirFinal(novo);
            return;
        }
        Nodo percorre = this.primeiro;
        while(percorre.getInformacao() <= novo.getInformacao()){
        percorre = percorre.getProximo();
        }
        novo.setProximo(percorre);
        novo.setAnterior(percorre.getAnterior());
        percorre.getAnterior().setProximo(novo);
        percorre.setAnterior(novo);
        
    }
//remover ultimo
    public void excluirUltimo(){
        if (estaVazia()){
            return;
        }
        if (this.primeiro == this.ultimo){
            iniciaLista();
            System.gc();
            return;
        }
        this.ultimo = this.ultimo.getAnterior();
        this.ultimo.setProximo(null);
        System.gc();
        return;
    }
//remover primeiro
    public void excluirPrimeiro(){
        if (estaVazia()){
            return;
        }
        if (this.primeiro == this.ultimo){
            iniciaLista();
            System.gc();
            return;
        }
        this.primeiro = this.primeiro.getProximo();
        this.ultimo.setAnterior(null);
        System.gc();
        return;
    }
//remover Ordenado
    public boolean excluirOrdenado(int remover){
    Nodo retorno = this.getNodo(remover);
    if (retorno == null){
        return false;
    }
    if (retorno == this.primeiro){
        this.excluirPrimeiro();
        return true;
    }
    if (retorno == this.ultimo){
        this.excluirUltimo();
        return true;
    }
    retorno.getAnterior().setProximo(retorno.getProximo());
    retorno.getProximo().setAnterior(retorno.getAnterior());
    retorno = null;
    System.gc();
    return true;
    }
}
