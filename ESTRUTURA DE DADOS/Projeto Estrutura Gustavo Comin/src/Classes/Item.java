package Classes;

import Enum.TipoArmazen;
import java.util.Date;

public class Item {
    private String nome;
    private int quantidade;
    private double peso;
    private TipoArmazen armazem;
    private int id;
    private double valor;
    //
    public Item(){
        this.setNome("padrão");
        this.setQuantidade(0);
        this.setPeso(0);
        this.setArmazem(armazem.CX);
        this.setID (0);
        this.setValor(0);
    }
    public Item(String nome, int quantidade, double peso, TipoArmazen armazem, int id, double valor){
        this.setNome(nome);
        this.setQuantidade(quantidade);
        this.setPeso(peso);
        this.setArmazem(armazem.CX);
        this.setID (id);
        this.setValor(valor);
    }
    //
    public void setNome(String nome){
        this.nome = nome.trim().isEmpty() ? "PADRÃO" : nome.toUpperCase();
    }
    public void setQuantidade(int quantidade){
        this.quantidade = quantidade < 0 ? 0 : quantidade;
    }
    public void setPeso(double peso){
        this.peso = peso <= 0 ? 0.01 : peso;
    }
    public void setArmazem(TipoArmazen armazem) {
        this.armazem = armazem == null ? TipoArmazen.CX : armazem;
    }
    public void setID(int id) {
        this.id = id < 0 ? 0 : id;
    }
    public void setValor(double valor) {
        this.valor = valor < 0 ? 0.01 : valor;
    }
    //
    
    public String getNome(){
        return this.nome;
    }
    public double getQuantidade(){
        return this.quantidade;
    }
    public double getPeso(){
        return this.peso;
    }
    public TipoArmazen getArmazem() {
        return armazem;
    }
    public int getID() {
        return id;
    }
    public double getValor() {
        return valor;
    }
    //
    public String toString(){
        return this.nome;
    }
}
