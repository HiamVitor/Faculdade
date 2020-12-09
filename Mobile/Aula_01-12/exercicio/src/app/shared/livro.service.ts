import { Livro } from './livro';
import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root',
})
export class LivroService {
    private livros: Livro[];

    constructor() {
        this.livros = [
            {
                codigo: 1,
                titulo: 'Dom Quixote',
                autor: 'Miguel de Cervantes',
                logo: 'https://www.revistabula.com/wp/wp-content/uploads/2016/11/Dom-Quixote.jpg',
                isbn: '8563560557',
            },
            {
                codigo: 2,
                titulo: 'Guerra e Paz',
                autor: 'Liev Tolstói',
                logo: 'https://www.revistabula.com/wp/wp-content/uploads/2016/11/Guerra-e-Paz.jpg',
                isbn: '8535930043',
            },
            {
                codigo: 3,
                titulo: 'A Montanha Mágica',
                autor: 'Thomas Mann',
                logo: 'https://www.revistabula.com/wp/wp-content/uploads/2016/11/A-Montanha-Magica.jpg',
                isbn: '8535928200',
            },
            {
                codigo: 4,
                titulo: 'Cem Anos de Solidão',
                autor: 'Gabriel García Márquez',
                logo: 'https://www.revistabula.com/wp/wp-content/uploads/2016/11/Cem-Anos-de-Solidao.jpg',
                isbn: '9788501012074',
            },
            {
                codigo: 5,
                titulo: 'Ulisses',
                autor: 'James Joyce',
                logo: 'https://www.revistabula.com/wp/wp-content/uploads/2016/11/Ulisses.jpg',
                isbn: '8563560425',
            },
            {
                codigo: 6,
                titulo: 'Em Busca do Tempo Perdido',
                autor: 'Marcel Proust',
                logo: 'https://www.revistabula.com/wp/wp-content/uploads/2016/11/Em-Busca-do-Tempo-Perdido.jpg',
                isbn: '8520926509',
            },
            {
                codigo: 7,
                titulo: 'A Divina Comédia',
                autor: 'Dante Alighieri',
                logo: 'https://www.revistabula.com/wp/wp-content/uploads/2016/11/A-Divina-Comedia.jpg',
                isbn: '85209858070000026509',
            },
            {
                codigo: 8,
                titulo: 'O Homem sem Qualidades',
                autor: 'Robert Musil',
                logo: 'https://www.revistabula.com/wp/wp-content/uploads/2016/11/O-Homem-sem-Qualidades.jpg',
                isbn: '8520942768',
            },
            {
                codigo: 9,
                titulo: 'O Processo',
                autor: 'Franz Kafka',
                logo: 'https://www.revistabula.com/wp/wp-content/uploads/2016/11/O-Processo.jpg',
                isbn: '8535907432',
            },
            {
                codigo: 10,
                titulo: 'O Som e a Fúria',
                autor: 'William Faulkner',
                logo: 'https://www.revistabula.com/wp/wp-content/uploads/2016/11/O-Som-e-a-Furia-1.jpg',
                isbn: '8535929428',
            },
        ];
    }

    getLivros() {
        return this.livros;
    }

    excluir(livro: Livro) {
        this.livros = this.livros.filter((l) => l.codigo !== livro.codigo);
    }
}
