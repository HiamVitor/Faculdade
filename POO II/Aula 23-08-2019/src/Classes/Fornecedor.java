
package Classes;

import Abstratas.Dados;

public class Fornecedor extends Dados{
    private String cnpj;
    private String endereco;
    private String telefone;
    private Cidade cidade;
    //
    public Fornecedor(){
        super();
        this.setCnpj("00.000.000/0000-00");
        this.setEndereco("padrão");
        this.setTelefone("(00)00000-0000");
        this.setCidade(null);
    }
    public Fornecedor(String nome,String cnpj,String endereco,
            String telefone, Cidade cidade){
        super(nome);
        this.setCnpj(cnpj);
        this.setEndereco(endereco);
        this.setTelefone(telefone);
        this.setCidade(cidade);
    }
    //
    public void setCnpj(String cnpj){
        this.cnpj = cnpj.trim().isEmpty()?"00.000.000/0000-00":cnpj;
    }
    public void setTelefone(String telefone){
        this.telefone = telefone.trim().isEmpty()?"(00)00000-0000":telefone;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco.trim().isEmpty()?"PADRÃO":endereco.toUpperCase();
    }
    public void setCidade(Cidade cidade){
        this.cidade = cidade == null ? new Cidade() : cidade;
    }
    //
    public String getCnpj(){
        return this.cnpj;
    }
    public String getEndereco(){
        return this.endereco;
    }
    public String getTelefone(){
        return this.telefone;
    }
    public Cidade getCidade(){
        return this.cidade;
    }
}
