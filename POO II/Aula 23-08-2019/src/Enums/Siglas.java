
package Enums;

public enum Siglas {
    RS("Rio Grande do Sul"),
    SC("Santa Catarina"),
    PR("Paraná"),
    SP("São Paulo"),
    RJ("Rio de Janeiro"),
    ES("Espírito Santo"),
    MT("Mato Grosso"),
    MS("Mato Grosso do Sul"),
    MG("Minas Gerais"),
    GO("Goiás"),
    TO("Tocantins"),
    DF("Distrito Federal"),
    BA("Bahia"),
    CE("Ceará"),
    AL("Alagoas"),
    MA("Maranhão"),
    AC("Acre"),
    AM("Amazonas"),
    RO("Rondônia"),
    RR("Roraima"),
    SE("Sergipe"),
    PA("Pará"),
    RN("Rio Grande do Norte"),
    PB("Paraíba"),
    PI("Piauí");
    //
    private String descricao;
    //
    private Siglas(String descricao) {
        this.descricao = descricao;
    }
    //
    @Override
    public String toString(){
        return this.descricao;
    }
    
}
