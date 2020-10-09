package Classes;

import Abstratas.Dados;

public class Combustivel extends Dados {
    //Atributos Especializados
    private double litros;
    private String data;
    
   //Construtores
    public Combustivel(){
        super();
        this.setLitros(0);
        this.setData("");
        }
    public Combustivel(String nome,String data, double litros){
        super(nome);
        this.setData(data);
        this.setLitros(litros);
        
    }    
    //SET'S
    public void setLitros(double litros){
        this.litros = litros < 0? 0 : litros;     
    }
    public void setData(String data){
        this.data = data.trim().isEmpty()?"(00/00/0000)":data;
    }
    //GET'S
     public double getLitros(){
         return this.litros;
     }
     public String getData(){
         return this.data;
     }
    
    
}
