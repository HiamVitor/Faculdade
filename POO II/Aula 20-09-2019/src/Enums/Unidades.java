
package Enums;

public enum Unidades {
    PC("Peça"),
    KIT("Kit"),
    LT("Litro"),
    MT("Metro"),
    PAR("Par");
    //
    private String descricao;
    //
    private Unidades(String descricao) {
        this.descricao = descricao;
    }
    //
    @Override
    public String toString() {
        return descricao;
    }   
}
