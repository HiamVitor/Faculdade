
package Enums;

public enum Tipo {
    MON("Monitor"),
    NOT("Notebook"),
    SER("Servidor"),
    DES("Desktop");
    //
    private String descricao;

    private Tipo(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
    
    
}
