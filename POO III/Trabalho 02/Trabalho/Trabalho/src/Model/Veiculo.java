package Model;

import Enums.Cambio;
import Enums.Combustivel;
import Enums.Tipos;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "VEICULOS")

public class Veiculo implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    @SwingColumn(description = "Código")
    private int id;
    //
    @Column(name = "NOME", nullable = false, length = 100)
    @SwingColumn(description = "Nome")
    private String nome;
    //
    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO", nullable = false)
    @SwingColumn(description = "Tipo ")
    private Tipos tipo;
    //
    @Enumerated(EnumType.STRING)
    @Column(name = "COMBUSTIVEL", nullable = false)
    @SwingColumn(description = "Combustivel")
    private Combustivel combustivel;
    //
    @Enumerated(EnumType.STRING)
    @Column(name = "CAMBIO", nullable = false)
    @SwingColumn(description = "Cambio")
    private Cambio cambio;
    //    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_MODELO", nullable = false, referencedColumnName = "ID")
    @SwingColumn(description = "Modelo")
    private Modelo modelo;
    //
    @Column(name = "Placa", nullable = false, length = 100)
    @SwingColumn(description = "Placa")
    private String placa;

    //
    public Veiculo() {

    }

    public Veiculo(int id, String nome, Tipos tipo, Combustivel combustivel, Cambio cambio,
            Modelo modelo, String placa) {
        this.setId(id);
        this.setNome(nome);
        this.setTipo(tipo);
        this.setCombustivel(combustivel);
        this.setCambio(cambio);
        this.setModelo(modelo);
        this.setPlaca(placa);
    }
    //
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome.trim().isEmpty() ? "NOME PADRÃO" : nome.toUpperCase();
    }

    public void setTipo(Tipos tipo) {
        this.tipo = tipo;
    }

    public void setCombustivel(Combustivel combustivel) {
        this.combustivel = combustivel;
    }

    public void setCambio(Cambio cambio) {
        this.cambio = cambio;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }
    
    public void setPlaca(String placa) {
        this.placa = placa.trim().isEmpty() ? "000-0000" : placa.toUpperCase();
    }

    //
    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public Tipos getTipo() {
        return this.tipo;
    }

    public Combustivel getCombustivel() {
        return this.combustivel;
    }

    public Cambio getCambio() {
        return this.cambio;
    }

    public Modelo getModelo() {
        return this.modelo;
    }
    
    public String getPlaca() {
        return this.placa;
    }

    //
    @Override
    public String toString() {
        return this.nome;
    }

    //
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.id;
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
        final Veiculo other = (Veiculo) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}
