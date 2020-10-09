
package Model;

import enums.Estados;

public class Instituicao implements java.io.Serializable{
    private int id;
    private String razao;
    private String endereco;
    private String cnpj;
    private Cidade cidade;
    //
    public Instituicao(){
        this.setId(0);
        this.setRazao("razão padrão");
        this.setEndereco("endereco padrão");
        this.setCnpj("00.000.000/0000-00");
        this.setCidade(null);
    }
    public Instituicao(int id,String razao,String endereco,String cnpj,Cidade cidade){
        this.setId(id);
        this.setRazao(razao);
        this.setEndereco(endereco);
        this.setCnpj(cnpj);
        this.setCidade(cidade);
    }
    //
    public void setId(int id){
        this.id=id;
    }
    public void setRazao(String razao){
        this.razao = razao.trim().isEmpty() ? "RAZÃO PADRÃO" : razao.toUpperCase();
    }
    public void setEndereco(String endereco){
        this.endereco = endereco.trim().isEmpty() ? "ENDEREÇO PADRÃO" : endereco.toUpperCase();
    }    
    public void setCnpj(String cnpj){
        this.cnpj = cnpj.trim().isEmpty() ? "00.000.000/0000-00" : cnpj;
    }    
    public void setCidade(Cidade cidade){
        this.cidade = cidade==null ? new Cidade(1, "", Estados.ES): cidade;
    }
    //
    public int getId(){
        return this.id;
    }
    public String getRazao(){
        return this.razao;
    }
    public String getEndereco(){
        return this.endereco;
    }
    public String getCnpj(){
        return this.cnpj;
    }
    public Cidade getCidade(){
        return this.cidade;
    }
    //
    @Override
    public String toString(){
        return this.razao + "("+this.cnpj+")";
    }
    //
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.id;
        return hash;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Instituicao other = (Instituicao) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}
