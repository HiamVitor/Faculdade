import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CondPagto } from './condpagto.model';
import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root',
})
export class CondPagtoService {
  private url = 'http://localhost:8080/concessionaria/api/condPagtos';
  
  constructor(private http: HttpClient) {}

    excluir(id: number): Observable<Object> {
      return this.http.delete(`${this.url}/${id}`);
    }

    salvar(condPagto: CondPagto) {
      if (condPagto.id) {
        return this.atualizar(condPagto);
      } else {
        return this.adicionar(condPagto);
      }
    }

    private adicionar(condPagto: CondPagto) {
      return this.http.post(this.url, condPagto);
    }

    private atualizar(condPagto: CondPagto) {
      return this.http.put(`${this.url}/${condPagto.id}`, condPagto);
    }

    getCondsPagto() : Observable<CondPagto[]> {
      return this.http.get<CondPagto[]>(this.url);
    }

    getCondPagto(id: number | number[]): Observable<CondPagto> {
      return this.http.get<CondPagto>(`${this.url}/${id}`);
    }
}
