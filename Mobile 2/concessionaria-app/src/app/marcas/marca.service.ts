import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Marca } from './marca.model';

@Injectable({
  providedIn: 'root'
})
export class MarcaService {
  
  private url = 'http://localhost:8080/concessionaria/api/marcas';

  constructor(
    private httpClient: HttpClient
  ) {}
  
  getMarcas(): Observable<Marca[]> {
    return this.httpClient.get<Marca[]>(this.url);
  }

  excluir(id: number): Observable<Object> {
    return this.httpClient.delete(`${this.url}/${id}`);
  }

  getMarca(id: number | number[]): Observable<Marca> {
    if(typeof id == 'number') {
      return this.httpClient.get<Marca>(`${this.url}/${id}`);
    }
    let idUrl: string = '?';
    id.forEach((i)=>{ idUrl += `id=${i}&` });
    idUrl = idUrl.substring(0,idUrl.length-1);
    return this.httpClient.get<Marca>(`${this.url}/${idUrl}`);
  }

  private adicionar(marca: Marca)  {
    return this.httpClient.post(this.url, marca);    
  }

  private atualizar(marca: Marca) {
    return this.httpClient.put(`${this.url}/${marca.id}`, marca);
  }

  salvar(marca: Marca) {
    if(marca.id) {
      return this.atualizar(marca);
    } else {
      return this.adicionar(marca);
    }
  }
}
