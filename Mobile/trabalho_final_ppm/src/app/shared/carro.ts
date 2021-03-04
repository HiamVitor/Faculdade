import { Combustivel } from './combustivel.enum';
import { Marca } from './marca';

export class Carro {
    codigo: number;
    nome: string;
    modelo: string;
    valor: number | string;
    dataLancamento: Date | string;
    logo: string;
    combustivel: Combustivel;
}
