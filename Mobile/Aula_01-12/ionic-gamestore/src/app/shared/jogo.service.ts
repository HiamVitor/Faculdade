import { Injectable } from '@angular/core';
import { Genero } from './genero.enum';
import { Jogo } from './jogo';

@Injectable({
    providedIn: 'root',
})
export class JogoService {
    private jogos: Jogo[];

    constructor() {
        this.jogos = [
            {
                codigo: 1,
                nome: 'Xadrez',
                valor: 25.9,
                logo:
                    'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTHonRz-2xTBzwy6uI_WPOfE66pBQsB4QYMj7AU9s3vRGoeuijchLHa-2fpSdY&usqp=CAc',
                genero: Genero.TABULEIRO,
                dataLancamento: new Date(1970, 0, 1),
            },
            {
                codigo: 2,
                nome: 'CS: GO',
                valor: 0.0,
                logo:
                    'https://banzika.com.br/image/cache/catalog/data/produtos/adesivos/csgo/csgologocores-1000x1000.jpg',
                genero: Genero.FPS,
                dataLancamento: new Date(2000, 11, 15),
            },
            {
                codigo: 3,
                nome: 'Need for Speed: Most Wanted',
                valor: '10.50',
                logo:
                    'https://www.grupobonobo.com.br/wp-content/uploads/2019/02/nfsmw.png',
                genero: Genero.CORRIDA,
                dataLancamento: new Date(2006, 2, 2),
            },
        ];
    }

    getJogos() {
        return this.jogos;
    }

    excluir(jogo: Jogo) {
        this.jogos = this.jogos.filter((j) => j.codigo !== jogo.codigo);
    }

    salvar(jogo: Jogo) {
        const indice = this.jogos.findIndex((j) => j.codigo === jogo.codigo);
        if (indice === -1) {
            // this.jogos.push(jogo);
            this.jogos = [...this.jogos, jogo];
        } else {
            this.jogos[indice] = { ...jogo };
        }
        console.log(this.jogos);
    }

    getCodigo() {
        return this.jogos.length + 1;
    }

    getJogo(codigo: number): Jogo {
        return this.jogos.find((j) => j.codigo === codigo);
    }
}
