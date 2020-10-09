
package Enums;

public enum TipoTitulacao {
    GRAD("Graduação",20.0),
    ESP("Especialização",25.0),
    MES("Mestrado",30.0),
    DOU("Doutorado",35.0),
    PHD("Pós-Doutorado",40.0);
    
    private String descricao;
    private double horaAula;

    private TipoTitulacao(String descricao, double horaAula) {
        this.descricao = descricao;
        this.horaAula = horaAula;
    }
    //
    public double getHoraAula(){
        return horaAula;
    }
    //
    public String toString(){
        return descricao;
    }
    
}
