package Enums;

public enum Combustivel {
    AlC("Alcool"),
    DIE("Diesel"),
    FLEX("Flex"),
    ELET("Elétrico"),
    GAS("Gasolina"),
    GNV("Gnv"),
    OUTROS("Outros");
    //
    private String descricao;

    //
    private Combustivel(String descricao) {
        this.descricao = descricao;
    }

    //
    @Override
    public String toString() {
        return descricao;
    }
}
