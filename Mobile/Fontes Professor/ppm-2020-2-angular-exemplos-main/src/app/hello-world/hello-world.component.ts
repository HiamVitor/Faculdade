import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-hello-world',
  templateUrl: './hello-world.component.html',
  styleUrls: ['./hello-world.component.css']
})
export class HelloWorldComponent implements OnInit {

  // public nome: string;
  // nome: string = "João";
  nome = "João";

  constructor() { 
    // this.nome = "João";
  }

  ngOnInit(): void {
  }
  
  // public void setNome() {} 
  // public setNome() : void {}
  // setNome(nome: string) {
  //   this.nome = nome;    
  // }
}
