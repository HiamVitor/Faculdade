package Enum;
public enum TipoArmazen {

    CX("Caixa"),
    CXPL("Caixa de Plastico"),
    CXP("Caixa de Papelão"),
    PC("Peça"),
    PL("Pallet"),
    CT("Container"),
    PLC("Plastico");
    
    private String Descricao;

    private TipoArmazen(String Descricao) {
        this.Descricao = Descricao;
    }

    public String getDescricao() {
        return Descricao;
    }

    @Override
    public String toString() {
        return Descricao;
    }
    
}
