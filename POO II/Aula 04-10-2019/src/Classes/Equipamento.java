package Classes;

import Enums.Tipo;
import java.time.LocalDate;

public class Equipamento {
    private String modelo;
    private Tipo tipo;
    private LocalDate aquisicao;
    private Cliente cliente;
    //

    public Equipamento() {
        this.setModelo("padrão");
        this.setTipo(Tipo.MON);
        this.setAquisicao(null);
        this.setCliente(null);
    }

    public Equipamento(String modelo, Tipo tipo, LocalDate aquisicao, Cliente cliente) {
        this.setModelo(modelo);
        this.setTipo(tipo);
        this.setAquisicao(aquisicao);
        this.setCliente(cliente);
    }
    //

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo.trim().isEmpty()?"PADRÃO":modelo.toUpperCase();
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo==null?Tipo.MON:tipo;
    }

    public LocalDate getAquisicao() {
        return aquisicao;
    }

    public void setAquisicao(LocalDate aquisicao) {
        this.aquisicao = aquisicao==null?LocalDate.now():aquisicao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente==null?new Cliente():cliente;
    }
    //

    @Override
    public String toString() {
        return modelo + " -> " + cliente;
    }
    
    
}
