
package Enums;

public enum Tipos {
    LIV("Livros"),
    REV("Revistas"),
    HQ("Histórias em Quadrinho"),
    MAN("Mangá");
    //
    private String descricao;
    //
    private Tipos(String descricao) {
        this.descricao = descricao;
    }
    //
    @Override
    public String toString(){
        return descricao;
    }
}
