
package Classes;

import Enums.Status;
import java.time.LocalDate;

public class Ordem {
    private int numero;
    private LocalDate abertura;
    private Tecnico tecnico;
    private Equipamento equipamento;
    private Status status;
    //

    public Ordem() {
        this.setNumero(9999);
        this.setAbertura(null);
        this.setEquipamento(null);
        this.setTecnico(null);
        this.setStatus(Status.A);
    }

    public Ordem(int numero, LocalDate abertura, 
            Tecnico tecnico, Equipamento equipamento,Status status) {
        this.setNumero(numero);
        this.setAbertura(abertura);
        this.setTecnico(tecnico);
        this.setEquipamento(equipamento);
        this.setStatus(status);
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero<=0?9999:numero;
    }

    public LocalDate getAbertura() {
        return abertura;
    }

    public void setAbertura(LocalDate abertura) {
        this.abertura = abertura==null?LocalDate.now():abertura;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico==null?new Tecnico():tecnico;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento==null?new Equipamento():equipamento;
    }
    public void setStatus(Status status){
        this.status=status==null?Status.A:status;
    }
    public Status getStatus(){
        return status;
    }

    @Override
    public String toString() {
        return numero + " -> " + equipamento;
    }
    
    
}
