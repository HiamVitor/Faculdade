import { Autor } from './autor';

export class Livro {
    titulo: string;
    autores: Autor[];
    quantidade: number;

    constructor(titulo: string, autores: Autor[] = [], quantidade = 0) {
        this.titulo = titulo;
        this.autores = autores;
        this.quantidade = quantidade;
    }
}
