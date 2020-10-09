
package Enums;

public enum Unidades {
    UND("Unidade"),
    PC("Peca"),
    KG("Kilo"),
    CX("Caixa"),
    PCT("Pacote"),
    KIT("Kit"),
    PAR("Par"),
    DZ("Dúzia");
    //
    private String descricao;
    //
    private Unidades(String descricao) {
        this.descricao = descricao;
    }
    //
    @Override
    public String toString(){
        return this.descricao;
    }
    
}
