import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Acessorio } from './acessorio.model';
import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root',
})
export class AcessorioService {
  private url = 'http://localhost:8080/concessionaria/api/acessorio';
  
  constructor(private http: HttpClient) {}

    excluir(id: number): Observable<Object> {
      return this.http.delete(`${this.url}/${id}`);
    }

    salvar(acessorio: Acessorio) {
      if (acessorio.id) {
        return this.atualizar(acessorio);
      } else {
        return this.adicionar(acessorio);
      }
    }

    private adicionar(acessorio: Acessorio) {
      return this.http.post(this.url, acessorio);
    }

    private atualizar(acessorio: Acessorio) {
      return this.http.put(`${this.url}/${acessorio.id}`, acessorio);
    }

    getAcessorios() : Observable<Acessorio[]> {
      return this.http.get<Acessorio[]>(this.url);
    }

    getAcessorio(id: number | number[]): Observable<Acessorio> {
      return this.http.get<Acessorio>(`${this.url}/${id}`);
    }
}
