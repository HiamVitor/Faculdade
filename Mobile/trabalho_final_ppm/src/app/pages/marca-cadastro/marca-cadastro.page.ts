import { Router, ActivatedRoute } from '@angular/router';
import { MarcaService } from './../../shared/marca.service';
import { Marca } from './../../shared/marca';
import { Component, OnInit } from '@angular/core';

@Component({
    selector: 'app-marca-cadastro',
    templateUrl: './marca-cadastro.page.html',
    styleUrls: ['./marca-cadastro.page.scss'],
})
export class MarcaCadastroPage implements OnInit {
    marca: Marca;

    constructor(
        private marcaService: MarcaService,
        private router: Router,
        private activatedRoute: ActivatedRoute
    ) {
        this.marca = new Marca();

        // tslint:disable-next-line: radix
        const codigo = parseInt(this.activatedRoute.snapshot.paramMap.get('codigo'));
        if (codigo) {
            this.marca = this.marcaService.getMarca(codigo);
        } else {
            this.marca.codigo =  this.marcaService.getCodigo();
        }
    }

    ngOnInit() {}

    salvar() {
        this.marcaService.salvar(this.marca);
        this.router.navigate(['marca-lista']);
    }
}
