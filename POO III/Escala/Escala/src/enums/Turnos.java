
package enums;

public enum Turnos {
    M("Matutino"),
    V("Vespertino"),
    N("Noturno");    
    //
    private String descricao;
    //
    private Turnos(String descricao) {
        this.descricao = descricao;
    }
    //
    @Override
    public String toString() {
        return descricao;    
    }
}
