
package Lista.Compra;

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
    private void incluirFinal(Nodo novo){
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
    private void incluirInicio(Nodo novo){
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
        if (novo.getInformacao().getNome().compareTo(this.primeiro.getInformacao().getNome())<=0){
            incluirInicio(novo);
            return;
        }
        //verificar se é maior que o último
        if (novo.getInformacao().getNome().compareTo(this.ultimo.getInformacao().getNome())>=0){
            incluirFinal(novo);
            return;
        }
        Nodo anterior = this.primeiro;
        Nodo atual    = this.primeiro.getProximo();
        while (novo.getInformacao().getNome().compareTo(atual.getInformacao().getNome())>=0){
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
              (!retorno.getInformacao().getNome().equalsIgnoreCase(busca))){
            retorno = retorno.getProximo();
        }
        return retorno;
    }
    private void removerInicio(){
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
    private void removerFinal(){
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
    //retornar o total das compras
    public double getTotalCompra(){
        double total=0;
        Nodo temp = this.primeiro;
        while(temp !=null){
            total += temp.getInformacao().getQuantidade()*
                     temp.getInformacao().getPeso();
            temp = temp.getProximo();
        }
        return total;
    }
    
}
