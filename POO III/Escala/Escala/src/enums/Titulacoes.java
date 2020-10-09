
package enums;

public enum Titulacoes {
    GRA("Graduação"),
    ESP("Especialização"),
    MES("Mestrado"),
    DOU("Doutorado"),
    PHD("Pós-Doutorado");
    //
    private String descricao;
    //
    private Titulacoes(String descricao) {
        this.descricao = descricao;
    }
    //
    @Override
    public String toString() {
        return descricao;
    }   
    
}
