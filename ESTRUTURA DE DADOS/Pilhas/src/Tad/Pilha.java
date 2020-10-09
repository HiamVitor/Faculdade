
package Tad;

public class Pilha implements Cloneable{
    private final int LIMITE=5;
    private String[] valores = new String[LIMITE];
    private int base;
    private int topo;
    //
    public Pilha(){
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
    public String topStack(){
        return this.isEmptyStack() ? "STACK UNDERFLOW" : this.valores[this.topo];
    }
    //---inserir um elemento no Topo
    public boolean pushStack(String novo){
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
    public Pilha getCopia(){
        Pilha copia = new Pilha();
        copia.base = this.base;
        copia.topo = this.topo;
        copia.valores = this.valores;
        return copia;
    }
    //
    @Override
    public Pilha clone() throws CloneNotSupportedException{
        return (Pilha)super.clone();
    }
    
}
