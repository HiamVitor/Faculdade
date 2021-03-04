import { Component, OnInit } from '@angular/core';

@Component({
    selector: 'app-consumo',
    templateUrl: './consumo.component.html',
    styleUrls: ['./consumo.component.css'],
})
export class ConsumoComponent implements OnInit {
    distancia: number;
    litros: number;
    calc;

    constructor() {
    }

    ngOnInit(): void {}

    calcular() {
        var me = this;
        this.calc = (this.distancia / this.litros).toFixed(2);
    }

    limpar() {
        this.distancia = null;
        this.litros = null;
        this.calc = 0;
    }
}
