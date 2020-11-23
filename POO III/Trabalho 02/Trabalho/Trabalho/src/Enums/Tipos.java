package Enums;

public enum Tipos {
    CARRO("Carro"),
    CAM("Caminhão"),
    MOTO("Moto"),
    OUTROS("Outros");
    //
    private String descricao;

    //
    private Tipos(String descricao) {
        this.descricao = descricao;
    }

    //
    @Override
    public String toString() {
        return descricao;
    }
}
