
package Enums;

public enum TipoSexo {
    M("Masculino"),
    F("Feminino");
    
    private String descricao;

    private TipoSexo(String descricao) {
        this.descricao = descricao;
    }
    
    @Override
    public String toString(){
        return descricao;
    }
    
}
