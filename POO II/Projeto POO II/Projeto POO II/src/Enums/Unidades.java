
package Enums;

public enum Unidades {
    //
    CO("Conta"),
    KIT("Kit"),
    MT("Metro"),
    CEN("Centena"),
    LI("Linha"),
    AG("Agulha");
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
