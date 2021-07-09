package br.com.concessionaria.api.carro;

import java.util.List;

public class CarroDTO {

    public Long id;
    public String modelo;
    public String imagem;
    public int ano;
    public Double preco;
    public Long marca;
    public List<Long> formas;
    public List<Long> conds;
    public List<Long> acessorios;    

    public CarroDTO(Long id, String modelo, String imagem, int ano, Double preco, Long marca, List<Long> formas, List<Long> conds, List<Long> acessorios) {
        this.id = id;
        this.modelo = modelo;
        this.imagem = imagem;
        this.ano = ano;
        this.preco = preco;
        this.marca = marca;
        this.formas = formas;
        this.conds = conds;
        this.acessorios = acessorios;
    }
}
