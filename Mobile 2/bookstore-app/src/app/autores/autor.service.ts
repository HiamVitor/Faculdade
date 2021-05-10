import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Autor } from './autor.model';

@Injectable({
  providedIn: 'root'
})
export class AutorService {
  
  private url = 'http://localhost:3000/autores';

  constructor(
    private httpClient: HttpClient
  ) {}
  
  getAutores(): Observable<Autor[]> {
    return this.httpClient.get<Autor[]>(this.url);
  }

  excluir(id: number): Observable<Object> {
    return this.httpClient.delete(`${this.url}/${id}`);
  }

  getAutor(id: number | number[]): Observable<Autor> {
    if(typeof id == 'number') {
      return this.httpClient.get<Autor>(`${this.url}/${id}`);
    }
    let idUrl: string = '?';
    id.forEach((i)=>{ idUrl += `id=${i}&` });
    idUrl = idUrl.substring(0,idUrl.length-1);
    return this.httpClient.get<Autor>(`${this.url}/${idUrl}`);
  }

  private adicionar(autor: Autor)  {
    return this.httpClient.post(this.url, autor);    
  }

  private atualizar(autor: Autor) {
    return this.httpClient.put(`${this.url}/${autor.id}`, autor);
  }

  salvar(autor: Autor) {
    if(autor.id) {
      return this.atualizar(autor);
    } else {
      return this.adicionar(autor);
    }
  }
}
