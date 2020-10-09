
package Enums;

public enum TipoTurno {
    M("Matutino"),
    V("Vespertino"),
    N("Noturno");
    
    private String descricao;

    private TipoTurno(String descricao) {
        this.descricao = descricao;
    }
    
    public String toString(){
        return this.descricao;
    }
}
