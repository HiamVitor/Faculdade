import { Genero } from './genero.enum';

export class Jogo {
    codigo: number;
    nome: string;
    valor: number | string;
    logo: string;
    genero: Genero | string;
    dataLancamento: Date | string;
}
