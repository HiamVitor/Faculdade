import { Combustivel } from './../../shared/combustivel.enum';
import { ActivatedRoute, Router } from '@angular/router';
import { CarroService } from './../../shared/carro.service';
import { Carro } from './../../shared/carro';
import { Component, OnInit } from '@angular/core';

@Component({
    selector: 'app-carro-cadastro',
    templateUrl: './carro-cadastro.page.html',
    styleUrls: ['./carro-cadastro.page.scss'],
})
export class CarroCadastroPage implements OnInit {
    carro: Carro;
    combustiveis = Object.keys(Combustivel).map((key) => ({
        valor: key,
        descricao: Combustivel[key],
    }));

    constructor(
        private carroService: CarroService,
        private router: Router,
        private activatedRoute: ActivatedRoute
    ) {
        this.carro = new Carro();

        // tslint:disable-next-line: radix
        const codigo = parseInt(this.activatedRoute.snapshot.paramMap.get('codigo'));
        if (codigo) {
            this.carro = this.carroService.getCarro(codigo);
            if (this.carro.dataLancamento instanceof Date) {
                this.carro.dataLancamento = this.carro.dataLancamento.toISOString();
            }
        } else {
            this.carro.codigo = this.carroService.getCodigo();
        }
    }

    ngOnInit() {}

    salvar() {
        this.carro.valor = parseFloat(this.carro.valor.toString());
        this.carro.combustivel = Combustivel[this.carro.combustivel];
        this.carroService.salvar(this.carro);
        this.router.navigate(['carro-lista']);
    }
}
