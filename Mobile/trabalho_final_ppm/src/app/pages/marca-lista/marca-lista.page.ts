import { ViewWillEnter } from '@ionic/angular';
import { Router } from '@angular/router';
import { MarcaService } from './../../shared/marca.service';
import { Marca } from './../../shared/marca';
import { Component, OnInit } from '@angular/core';

@Component({
    selector: 'app-marca-lista',
    templateUrl: './marca-lista.page.html',
    styleUrls: ['./marca-lista.page.scss'],
})
export class MarcaListaPage implements OnInit, ViewWillEnter {
    listaMarcas: Marca[];

    constructor(private marcaService: MarcaService, private router: Router) {}

    ngOnInit() {}

    ionViewWillEnter() {
        this.listar();
    }

    listar() {
        this.listaMarcas = this.marcaService.getMarcas();
    }

    editar(marca: Marca) {
        this.router.navigate(['marca-cadastro', marca.codigo]);
    }

    excluir(marca: Marca) {
        this.marcaService.excluir(marca);
        this.listar();
    }
}
