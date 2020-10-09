
package Abstratas;
public abstract class Pessoa extends Dados {
   private String endereco;
   private String telefone;
   //
   public Pessoa(){
       super();
       this.setEndereco("");
       this.setTelefone("");
   }
   public Pessoa(String nome, String endereco, String telefone){
       super(nome);
       this.setEndereco(endereco);
       this.setTelefone(telefone);
   }
   //
   public void setEndereco (String endereco){
       this.endereco = endereco.trim().isEmpty()?"ENDERÇO PADRÂO":endereco.toUpperCase();
   }
   public void setTelefone(String telefone){
       this.telefone = telefone.trim().isEmpty()?"(00)00000-0000":telefone;
   }
   //
   public String getEndereco(){
       return this.endereco;
   }
   public String getTelefone(){
       return this.telefone;
   }
   
}
