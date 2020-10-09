package Classes;
public class Consumo extends Abstratas.Dados{
    //Atributos Especializados
    private double quilometros;
    private double litros;
    //Contrutores
    public Consumo(){
        super();
        this.setKm(0);
        this.setLitros(0);
    }
    public Consumo(String nome, double quilometros, double litros){
        super(nome);
        this.setKm(quilometros);
        this.setLitros(litros);
    }
    //SET'S
    public void setKm(double quilometros){
        this.quilometros = quilometros < 0? 0 : quilometros;
    }
    public void setLitros(double litros){
        this.litros = litros < 0? 0 : litros;     
    }
    //GET'S
    public double getKm(){
        return this.quilometros;
    }
    public double getLitros(){
        return this.litros;
    }
}
