
package Tad;

public class PilhaLivro implements Cloneable{
    private final int LIMITE=5;
    //
    private Livro[] valores = new Livro[LIMITE];
    private int base;
    private int topo;
    //
    public PilhaLivro(){
        this.clearStack();
    }
    //---inicializa uma Pilha
    public void clearStack(){
        this.base = -1;
        this.topo = -1;        
    }
    //---Verifica se está Vazia
    public boolean isEmptyStack(){
        return (this.base == -1);
    }
    //---Verifica se está Cheia
    public boolean isFullStack(){
        return (this.topo == LIMITE-1);
    }
    //---retornar o Topo
    public Livro topStack(){
        return this.isEmptyStack() ? null : this.valores[this.topo];
    }
    //---inserir um elemento no Topo
    public boolean pushStack(Livro novo){
        if (isFullStack()){
            return false;
        }
        if (this.isEmptyStack()){
            this.base = 0;
        }
        this.valores[++topo] = novo;
        return true;
    }
    //---remover o Topo da Pilha
    public boolean popStack(){
        if (this.isEmptyStack()){
            return false;
        }
        if (this.base == this.topo){//só existe 1 elemento
            this.clearStack();
            return true;
        }
        this.topo--;
        return true;
    }
    //
    @Override
    public PilhaLivro clone() throws CloneNotSupportedException{
        return (PilhaLivro)super.clone();
    }    
}
