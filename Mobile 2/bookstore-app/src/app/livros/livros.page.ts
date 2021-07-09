import { Component, OnInit } from '@angular/core';
import { AlertController, IonItemSliding, NavController } from '@ionic/angular';
import { Autor } from '../autores/autor.model';
import { AutorService } from '../autores/autor.service';
import { Livro } from './livro.model';
import { LivroService } from './livro.service';

@Component({
  selector: 'app-livros',
  templateUrl: './livros.page.html',
  styleUrls: ['./livros.page.scss'],
})
export class LivrosPage implements OnInit {
  public livros: Livro[];

  constructor(
    private livroService: LivroService,
    private autorService: AutorService,
    private alertController: AlertController,
    private navController: NavController
  ) {}

  ngOnInit() {}

  ionViewWillEnter() {
    this.listar();
  }

  listar() {
    this.livroService.getLivros().subscribe((livrosViewmodel) => {
      let livros: Livro[] = [];
      livrosViewmodel.forEach((livroViewmodel) => {
        let livro: Livro;
        let livroSemAutor: any = Object.assign({}, livroViewmodel);
        livroSemAutor.autores = [] as Autor[];
        livro = livroSemAutor;

        this.autorService
          .getAutor(livroViewmodel.autores)
          .subscribe((autor) => {
            livro.autores.push(...(autor as any));
          });

        livros.push(livro);
      });
      this.livros = livros;
    });
  }

  async exclusao(livro: Livro, slidingItem: IonItemSliding) {
    const alert = await this.alertController.create({
      header: 'Confirmação de exclusão',
      message: `Deseja excluir o livro ${livro.nome}?`,
      buttons: [
        {
          text: 'Sim',
          handler: () => this.excluir(livro),
        },
        {
          text: 'Não',
          handler: () => slidingItem.close(),
        },
      ],
    });
    alert.present();
  }

  excluir(livro: Livro) {
    this.livroService.excluir(livro).subscribe(() => this.listar());
  }

  editar(livro: Livro, slidingItem: IonItemSliding) {
    this.navController.navigateForward([`livros/cadastro/${livro.id}`]);
    slidingItem.close();
  }
}
