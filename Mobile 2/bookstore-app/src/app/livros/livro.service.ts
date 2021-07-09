import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Livro, LivroViewModel } from './livro.model';

@Injectable({
  providedIn: 'root',
})
export class LivroService {
  uri: string;

  constructor(private http: HttpClient) {
    this.uri = 'http://localhost:3000/livros';
  }

  getLivros() {
    return this.http.get<LivroViewModel[]>(`${this.uri}`);
  }

  salvar(livro: LivroViewModel) {
    return livro && livro.id ? this.atualizar(livro) : this.adicionar(livro);
  }

  private atualizar(livro: LivroViewModel) {
    return this.http.put(`${this.uri}/${livro.id}`, livro);
  }

  private adicionar(livro: LivroViewModel) {
    return this.http.post(`${this.uri}`, livro);
  }

  excluir(livro: Livro) {
    return this.http.delete(`${this.uri}/${livro.id}`);
  }

  getLivro(id: number) {
    return this.http.get<LivroViewModel>(`${this.uri}/${id}`);
  }
}
