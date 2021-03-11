import { Autor } from './autor.model';
import { Component, OnInit } from '@angular/core';
import { Genero } from '../Enums/Genero.enum';

@Component({
  selector: 'app-autores',
  templateUrl: './autores.page.html',
  styleUrls: ['./autores.page.scss'],
})
export class AutoresPage implements OnInit {
  autores: Autor[];

  constructor() {
    this.autores = [
      {
        nome: 'David Flanagan',
        dataNascimento: new Date(1980, 11, 13),
        sexo: Genero.MASCULINO,
      },
      {
        nome: 'Douglas Cockford',
        dataNascimento: new Date(1975, 5, 17),
        sexo: Genero.MASCULINO,
      },
      {
        nome: 'Martin Fowler',
        dataNascimento: new Date(1960, 5, 17),
        sexo: Genero.MASCULINO,
      },
    ];
  }

  ngOnInit() {}
}
