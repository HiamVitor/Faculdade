package TAD;

public class Fila implements Cloneable{
    private final int LIMITE=5;
    private int primeiro;
    private int ultimo;
    private String[] valores = new String[LIMITE];
    //
    public Fila(){
        this.clearQueue();
    }
    //
    public void clearQueue(){
        this.primeiro = -1;
        this.ultimo   = -1;
    }
    //
    public boolean isEmptyQueue(){
        return (this.primeiro == -1);
    }
    //
    public boolean isFullQueue(){
        return (this.ultimo == LIMITE-1);
    }
    //
    public String firstQueue(){
        return (this.isEmptyQueue()?"UNDERFLOW":this.valores[this.primeiro]);
    }
    //
    public boolean enQueue(String novoValor){
        if (this.isFullQueue()){
            return false;
        }else{
            if (this.isEmptyQueue()){
                this.primeiro++;
            }
            this.valores[++this.ultimo] = novoValor;
            return true;
        }
    }
    public boolean deQueue(){
        if (this.isEmptyQueue()){
            return false;
        }else{
            if (this.primeiro==this.ultimo){
                this.clearQueue();
                return true;
            }
            this.primeiro++;
            return true;
        }
    }
    //criar clone
    public Fila clone() throws CloneNotSupportedException{
        return (Fila)super.clone();
    }
}
