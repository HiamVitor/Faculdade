
package Enums;

public enum Sexos {
    M("Masculino"),
    F("Feminino");
    //
    private String descricao;
    //
    private Sexos(String descricao) {
        this.descricao = descricao;
    }
    //
    @Override
    public String toString() {
        return descricao;
    }
}
