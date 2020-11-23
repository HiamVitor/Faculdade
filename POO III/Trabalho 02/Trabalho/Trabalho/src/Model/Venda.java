package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "VENDA")

public class Venda implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    @SwingColumn(description = "Código")
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_PAGAMENTO", nullable = false, referencedColumnName = "ID")
    @SwingColumn(description = "Pagamento")
    private Pagamento pagamento;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_VEICULO", nullable = false, referencedColumnName = "ID")
    @SwingColumn(description = "Veiculo")
    private Veiculo veiculo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_MODELO", nullable = false, referencedColumnName = "ID")
    @SwingColumn(description = "Modelo")
    private Modelo modelo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_Vendedor", nullable = false, referencedColumnName = "ID")
    @SwingColumn(description = "Vendedor")
    private Vendedor vendedor;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_Cliente", nullable = false, referencedColumnName = "ID")
    @SwingColumn(description = "Cliente")
    private Cliente cliente;

    @Column(name = "VALOR", nullable = false, scale = 2)
    private double valor;

    public Venda() {

    }

    public Venda(int id, Pagamento pagamento, Veiculo veiculo, Modelo modelo,
            double valor, Vendedor vendedor, Cliente cliente) {
        
        this.setId(id);
        this.setPagamento(pagamento);
        this.setVeiculo(veiculo);
        this.setModelo(modelo);
        this.setValor(valor);
        this.setVendedor(vendedor);
        this.setCliente(cliente);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setValor(double valor) {
        this.valor = valor <= 0 ? 0.01 : valor;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public int getId() {
        return this.id;
    }

    public Pagamento getPagamento() {
        return this.pagamento;
    }

    public Veiculo getVeiculo() {
        return this.veiculo;
    }

    public Vendedor getVendedor() {
        return this.vendedor;
    }
    
    public Cliente getCliente() {
        return this.cliente;
    }

    public double getValor() {
        return this.valor;
    }

    public Modelo getModelo() {
        return this.modelo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.id;
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
        final Venda other = (Venda) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}
