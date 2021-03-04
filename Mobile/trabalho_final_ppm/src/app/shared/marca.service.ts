import { Marca } from './marca';
import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root',
})
export class MarcaService {
    private marcas: Marca[];

    constructor() {
        this.marcas = [
            {
                codigo: 1,
                nome: 'Renault',
                logo:
                    'https://sindojus-ce.org.br/wp-content/uploads/2017/11/Renault-logo-2015-2048x2048_editada-e1511874036882.png',
            },
        ];
    }

    getMarcas() {
        return this.marcas;
    }

    excluir(marca: Marca) {
        this.marcas = this.marcas.filter((m) => m.codigo !== marca.codigo);
    }

    salvar(marca: Marca) {
        const indice = this.marcas.findIndex((m) => m.codigo === marca.codigo);
        if (indice === -1) {
            this.marcas = [...this.marcas, marca];
        } else {
            this.marcas[indice] = { ...marca };
        }
    }

    getCodigo() {
        return this.marcas.length + 1;
    }

    getMarca(codigo: number): Marca {
        return this.marcas.find((n) => n.codigo === codigo);
    }
}
