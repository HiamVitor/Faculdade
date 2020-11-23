package Enums;

public enum Cambio {
    AUT("Automático"),
    MAN("Manual");
    //
    private String descricao;

    //
    private Cambio(String descricao) {
        this.descricao = descricao;
    }

    //
    @Override
    public String toString() {
        return descricao;
    }
}
