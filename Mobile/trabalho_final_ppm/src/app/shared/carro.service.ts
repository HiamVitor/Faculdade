import { Combustivel } from './combustivel.enum';
import { Carro } from './carro';
import { Injectable } from '@angular/core';
import { Marca } from './marca';

@Injectable({
    providedIn: 'root',
})
export class CarroService {
    private carros: Carro[];

    constructor() {
        this.carros = [
            {
                codigo: 1,
                nome: 'Kwid',
                modelo: '2019',
                valor: 35000,
                dataLancamento: new Date(2019, 0, 1),
                logo:
                    'https://i0.statig.com.br/bancodeimagens/dg/c0/iv/dgc0ivvwzbh30ra67c209ybks.jpg',
                combustivel: Combustivel.FLEX,
            },
        ];
    }

    getCarros() {
        return this.carros;
    }

    excluir(carro: Carro) {
        this.carros = this.carros.filter((c) => c.codigo !== carro.codigo);
    }

    salvar(carro: Carro) {
        const indice = this.carros.findIndex((c) => c.codigo === carro.codigo);
        if (indice === -1) {
            // this.carros.push(carro);
            this.carros = [...this.carros, carro];
        } else {
            this.carros[indice] = { ...carro };
        }
        console.log(this.carros);
    }

    getCodigo() {
        return this.carros.length + 1;
    }

    getCarro(codigo: number): Carro {
        return this.carros.find((c) => c.codigo === codigo);
    }
}
