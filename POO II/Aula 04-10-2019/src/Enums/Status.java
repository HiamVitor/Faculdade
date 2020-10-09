package Enums;

public enum Status {
    A("Aberta"),
    T("Em Atendimento"),
    C("Cancelada"),
    F("Finalizada");    
    private String descricao;
    
    private Status(String descricao) {
        this.descricao = descricao;
    }
    @Override
    public String toString() {
        return descricao;
    }
    
    
}
