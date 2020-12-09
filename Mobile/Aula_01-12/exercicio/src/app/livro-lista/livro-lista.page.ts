import { LivroService } from './../shared/livro.service';
import { Livro } from './../shared/livro';
import { Component, OnInit } from '@angular/core';

@Component({
    selector: 'app-livro-lista',
    templateUrl: './livro-lista.page.html',
    styleUrls: ['./livro-lista.page.scss'],
})
export class LivroListaPage implements OnInit {
    listaLivros: Livro[];

    constructor(private livroService: LivroService) {}

    ngOnInit() {
        this.listar();
    }

    listar() {
        this.listaLivros = this.livroService.getLivros();
    }

    excluir(livro: Livro) {
        this.livroService.excluir(livro);
        this.listar();
    }
}
