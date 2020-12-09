import { Component, OnInit } from "@angular/core";
import { Router } from '@angular/router';
import { ViewWillEnter } from "@ionic/angular";
import { Genero } from "../shared/genero.enum";
import { Jogo } from "../shared/jogo";
import { JogoService } from "../shared/jogo.service";

@Component({
  selector: "app-jogo-lista",
  templateUrl: "./jogo-lista.page.html",
  styleUrls: ["./jogo-lista.page.scss"],
})
export class JogoListaPage implements OnInit, ViewWillEnter {
  listaJogos: Jogo[];

  constructor(
    private jogoService: JogoService,
    private router: Router
  ) {}

  ngOnInit() {}

  ionViewWillEnter() {
    this.listar();
  }

  listar() {
    this.listaJogos = this.jogoService.getJogos();
  }

  editar(jogo: Jogo) {
    this.router.navigate(['jogo-cadastro', jogo.codigo]);
  }

  excluir(jogo: Jogo) {
    this.jogoService.excluir(jogo);
    this.listar();
  }

}
