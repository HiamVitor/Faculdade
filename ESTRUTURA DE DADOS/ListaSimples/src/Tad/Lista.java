
package Tad;

public class Lista {
    private Nodo primeiro;
    private Nodo ultimo;
    
    public Lista(){
        iniciaLista();
    }
    //
    public Nodo getPrimeiro(){
        return this.primeiro;
    }
    public void iniciaLista(){
        this.primeiro = null;
        this.ultimo   = null;
    }
    //
    public boolean estaVazia(){
        return (this.primeiro == null);
    }
    //
    public void incluirFinal(Nodo novo){
        if (estaVazia()){
            this.primeiro = novo;
            this.ultimo   = novo;
            novo.setProximo(null);
            return;
        }
        this.ultimo.setProximo(novo);
        this.ultimo = novo;
        novo.setProximo(null);
    }
    public void incluirInicio(Nodo novo){
        if (estaVazia()){
            this.primeiro = novo;
            this.ultimo   = novo;
            novo.setProximo(null);
            return;
        }
        novo.setProximo(primeiro);
        this.primeiro = novo;        
    }  
    //incluir na lista mantendo ordenada alfabeticamente
    public void incluirOrdenado(Nodo novo){
        if (estaVazia()){
            incluirFinal(novo);
            return;
        }
        //verificar se é menor que o primeiro
        if (novo.getInformacao().compareTo(this.primeiro.getInformacao())<=0){
            incluirInicio(novo);
            return;
        }
        //verificar se é maior que o último
        if (novo.getInformacao().compareTo(this.ultimo.getInformacao())>=0){
            incluirFinal(novo);
            return;
        }
        Nodo anterior = this.primeiro;
        Nodo atual    = this.primeiro.getProximo();
        while (novo.getInformacao().compareTo(atual.getInformacao())>=0){
            anterior = anterior.getProximo();
            atual    = atual.getProximo();
        }
        anterior.setProximo(novo);
        novo.setProximo(atual);        
    }
    //retornar um elemento a partir de um parametro
    public Nodo getNodo(String busca){
        Nodo retorno = this.primeiro;
        while ((retorno != null)&&
              (!retorno.getInformacao().equalsIgnoreCase(busca))){
            retorno = retorno.getProximo();
        }
        return retorno;
    }
    public void removerInicio(){
        if (this.estaVazia()){
            return;
        }
        if (this.primeiro==this.ultimo){
            this.iniciaLista();
            System.gc();
            return;
        }
        this.primeiro = this.primeiro.getProximo();
        System.gc();
    }
    public void removerFinal(){
        if (this.estaVazia()){
            return;
        }
        if (this.primeiro==this.ultimo){
            this.iniciaLista();
            System.gc();
            return;
        }
        Nodo temp = this.primeiro;
        while(temp.getProximo() != this.ultimo){
            temp = temp.getProximo();
        }
        this.ultimo = temp;
        this.ultimo.setProximo(null);
        System.gc();
    }
    public boolean removeIntermediario(String remover){
        if (this.estaVazia()){
            return false;
        }
        Nodo excluir = this.getNodo(remover);
        //se não existir o nodo
        if (excluir == null){
            return false;
        }
        //se existir apenas 1 elemento
        if (this.primeiro == this.ultimo){
            this.removerInicio();
            return true;
        }
        // se o nodo for o primeiro
        if (excluir == this.primeiro){
            this.removerInicio();
            return true;
        }
        // se o nodo for o último
        if (excluir == this.ultimo){
            this.removerFinal();
            return true;
        }
        Nodo percorre = this.primeiro;
        while (percorre.getProximo() != excluir){
            percorre = percorre.getProximo();
        }
        percorre.setProximo(excluir.getProximo());
        excluir = null;
        System.gc();
        return true;
    }
    
}
