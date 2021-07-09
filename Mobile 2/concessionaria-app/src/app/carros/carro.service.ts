import { Injectable } from '@angular/core';
import { CarroViewModel } from './carro.model';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CarroService {
  uri: string;

  constructor(private http: HttpClient) {
     this.uri = 'http://localhost:8080/concessionaria/api/carros';
  }

  getCarros() {
    return this.http.get<CarroViewModel[]>(`${this.uri}`);
  }

  salvar(carro: CarroViewModel) {
    return (carro && carro.id) ? this.atualizar(carro) : this.adicionar(carro);
  }

  private atualizar(carro: CarroViewModel) {
    const carroDTO = {
      id: carro.id,
      modelo: carro.modelo,
      ano: carro.ano,
      preco: carro.preco,
      imagem: carro.imagem,
      marca: { id: carro.marca },
      placa: carro.placa,
      formaPagto: carro.formas.map(function(forma) { return { id: forma } }),
      condPagto: carro.condicoes.map(function(cond) { return { id: cond } }),
      acessorio: carro.acessorios.map(function(acessorio) { return { id: acessorio } })
    }
    return this.http.put(`${this.uri}/${carro.id}`, carroDTO);
  }

  private adicionar(carro: CarroViewModel) {
    const carroDTO = {
      id: carro.id,
      modelo: carro.modelo,
      ano: carro.ano,
      preco: carro.preco,
      imagem: carro.imagem,
      marca: { id: carro.marca },
      placa: carro.placa,
      formaPagto: carro.formas.map(function(forma) { return { id: forma } }),
      condPagto: carro.condicoes.map(function(cond) { return { id: cond } }),
      acessorio: carro.acessorios.map(function(acessorio) { return { id: acessorio } })
    }
    return this.http.post(`${this.uri}`, carroDTO);
  }

  excluir(carro: CarroViewModel) {
    return this.http.delete(`${this.uri}/${carro.id}`);
  }

  getCarro(id: number) {
    return this.http.get<CarroViewModel>(`${this.uri}/${id}`);
  }
}

