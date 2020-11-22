import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-hello-world',
  templateUrl: './hello-world.component.html',
  styleUrls: ['./hello-world.component.css']
})
export class HelloWorldComponent implements OnInit {

  public nome: string;

  constructor() {
    this.nome = "Gustavo";
  }

  setNome(event){
    this.nome = event.target.value;
  }

  ngOnInit(): void {
  }

}
