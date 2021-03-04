import { CarroService } from './../../shared/carro.service';
import { Component, OnInit } from '@angular/core';
import { Carro } from 'src/app/shared/carro';
import { Router } from '@angular/router';
import { ViewWillEnter } from '@ionic/angular';

@Component({
    selector: 'app-carro-lista',
    templateUrl: './carro-lista.page.html',
    styleUrls: ['./carro-lista.page.scss'],
})
export class CarroListaPage implements OnInit, ViewWillEnter {
    listaCarros: Carro[];

    constructor(private carroService: CarroService, private router: Router) {}

    ngOnInit() {}

    ionViewWillEnter() {
        this.listar();
    }

    listar() {
        this.listaCarros = this.carroService.getCarros();
    }

    editar(carro: Carro) {
        this.router.navigate(['carro-cadastro', carro.codigo]);
    }

    excluir(carro: Carro) {
        this.carroService.excluir(carro);
        this.listar();
    }
}
