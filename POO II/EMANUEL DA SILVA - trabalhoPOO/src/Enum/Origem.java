
package Enum;
public enum Origem {
    NAC ("NACIONAL"),
    IMP ("IMPORTADO");
    
    private String descricao;
    
    private Origem(String descricao){
        this.descricao = descricao;
    }
    
    public String getDescricao(){
        return descricao;
    }
    
    @Override
    public String toString() {
        return descricao;
    }
}
