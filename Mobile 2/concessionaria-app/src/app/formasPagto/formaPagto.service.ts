import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { FormaPagto } from './formaPagto.model';
import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root',
})
export class FormaPagtoService {
  private url = 'http://localhost:8080/concessionaria/api/formasPagto';
  
  constructor(private http: HttpClient) {}

    excluir(id: number): Observable<Object> {
      return this.http.delete(`${this.url}/${id}`);
    }

    salvar(formaPagto: FormaPagto) {
      if (formaPagto.id) {
        return this.atualizar(formaPagto);
      } else {
        return this.adicionar(formaPagto);
      }
    }

    private adicionar(formaPagto: FormaPagto) {
      return this.http.post(this.url, formaPagto);
    }

    private atualizar(formaPagto: FormaPagto) {
      return this.http.put(`${this.url}/${formaPagto.id}`, formaPagto);
    }

    getFormas() : Observable<FormaPagto[]> {
      return this.http.get<FormaPagto[]>(this.url);
    }

    getForma(id: number | number[]): Observable<FormaPagto> {
      return this.http.get<FormaPagto>(`${this.url}/${id}`);
    }
}
