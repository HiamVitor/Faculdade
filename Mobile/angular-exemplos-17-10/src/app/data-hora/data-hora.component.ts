import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-data-hora',
  templateUrl: './data-hora.component.html',
  styleUrls: ['./data-hora.component.css']
})
export class DataHoraComponent implements OnInit {

  dataHoraAtual:Date;

  constructor() {
    this.updateDataHoraAtual();

    setInterval(
      () => this.updateDataHoraAtual(),
      1000
    );
  }

  ngOnInit(): void {
  }

  updateDataHoraAtual() {
    this.dataHoraAtual = new Date();
  }

}
