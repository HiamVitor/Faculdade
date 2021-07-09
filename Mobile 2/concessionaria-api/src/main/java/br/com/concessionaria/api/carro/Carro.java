package br.com.concessionaria.api.carro;

import br.com.concessionaria.api.acessorios.Acessorio;
import br.com.concessionaria.api.condPagto.CondPagto;
import br.com.concessionaria.api.formaPagto.FormaPagto;
import br.com.concessionaria.api.marca.Marca;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "carro", schema = "public")
public class Carro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String modelo;
    private int ano;
    private Double preco;
    private String imagem;
    private String placa;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Marca marca;

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "forma_carros",
            joinColumns = @JoinColumn(name = "id_carro_forma"),
            inverseJoinColumns = @JoinColumn(name = "id_forma"),
            foreignKey = @ForeignKey(name = "fk_carro_forma"),
            inverseForeignKey = @ForeignKey(name = "fk_forma")
    )
    private Set<FormaPagto> formaPagto = new HashSet<FormaPagto>();
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "cond_carros",
            joinColumns = @JoinColumn(name = "id_carro_cond"),
            inverseJoinColumns = @JoinColumn(name = "id_cond"),
            foreignKey = @ForeignKey(name = "fk_carro_cond"),
            inverseForeignKey = @ForeignKey(name = "fk_cond")
    )
    private Set<CondPagto> condPagto = new HashSet<CondPagto>();
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "acessorio_carros",
            joinColumns = @JoinColumn(name = "id_carro_acessorio"),
            inverseJoinColumns = @JoinColumn(name = "id_acessorio"),
            foreignKey = @ForeignKey(name = "fk_carro_assesorio"),
            inverseForeignKey = @ForeignKey(name = "fk_acessorio")
    )
    private Set<Acessorio> acessorio = new HashSet<Acessorio>();

    public Set<FormaPagto> getFormaPagto() {
        return formaPagto;
    }

    public void setFormaPagto(Set<FormaPagto> formaPagto) {
        this.formaPagto = formaPagto;
    }

    public Set<CondPagto> getCondPagto() {
        return condPagto;
    }

    public void setCondPagto(Set<CondPagto> condPagto) {
        this.condPagto = condPagto;
    }

    public Set<Acessorio> getAcessorio() {
        return acessorio;
    }

    public void setAcessorio(Set<Acessorio> acessorio) {
        this.acessorio = acessorio;
    }

    

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
