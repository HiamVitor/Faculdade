import { Autor } from "../autores/autor.model";

export interface LivroBase {
    id?: number;
    nome: string;
    isbn: string;
    paginas: number;
    preco: number; 
    imagem: string;
}

export interface Livro extends LivroBase {
    autores: Autor[];
}

export interface LivroViewModel extends LivroBase {
    autores: number[]
}