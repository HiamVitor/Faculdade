import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastController } from '@ionic/angular';
import { Autor } from 'src/app/autores/autor.model';
import { AutorService } from 'src/app/autores/autor.service';
import { LivroViewModel } from '../livro.model';
import { LivroService } from '../livro.service';

@Component({
  selector: 'app-livros-cadastro',
  templateUrl: './livros-cadastro.component.html',
  styleUrls: ['./livros-cadastro.component.scss'],
})
export class LivrosCadastroComponent implements OnInit {

  livroId: number;
  livrosForm: FormGroup;

  autoresLista: Autor[];

  constructor(
    private toastController: ToastController,
    private activatedRoute: ActivatedRoute,
    private livroService: LivroService,
    private autorService: AutorService,
    private router: Router,
  ) {
    let livro = {
      id: null,
      nome: '',
      isbn: '',
      autores: [] as number[],
      paginas: 0,
      preco: 0, 
      imagem: ''
    };
    this.autorService.getAutores().subscribe(
      (dados) => {
        this.autoresLista = dados;
      }, 
      (erro) => {
        console.error(erro);
      }
    );
    this.initializaFormulario(livro);
  }

  ngOnInit() {
    const id = this.activatedRoute.snapshot.paramMap.get('id');
    if(id) {
      this.livroId = parseInt(id);
      this.livroService
        .getLivro(this.livroId)
        .subscribe((livroViewModel) => {
          this.initializaFormulario(livroViewModel as any);
          this.autores.setValue(livroViewModel.autores);
        });
    }
  }

  initializaFormulario(livro: LivroViewModel) {
    this.livrosForm = new FormGroup({
      nome: new FormControl(livro.nome, [
        Validators.required,
        Validators.minLength(3),
        Validators.maxLength(150),
      ]),
      isbn: new FormControl(livro.isbn, [
        Validators.required,
        Validators.minLength(3),
        Validators.maxLength(150),
      ]),      
      autores: new FormControl(livro.autores, (control)=>{ return control.value.length ? null: ["O livro deve possuir pelo menos um autor"]; }),
      paginas: new FormControl(livro.paginas),
      preco: new FormControl(livro.preco),
      imagem: new FormControl(livro.imagem)
    })
  }

  salvar() {
    const livro: LivroViewModel = {...this.livrosForm.value, id: this.livroId}
    this.livroService.salvar(livro).subscribe(
      () => this.router.navigate(['livros']),
      (erro) => {
        console.error(erro);
        this.toastController.create({
          message: `Não foi possível salvar o livro ${livro.nome}`,
          duration: 5000,
          keyboardClose: true,
          color: 'danger'
        }).then(t => t.present());
      }
    );
  }

  get nome() {
    return this.livrosForm.get('nome');
  }

  get isbn() {
    return this.livrosForm.get('isbn');
  }

  get autores() {
    return this.livrosForm.get('autores');
  }

  get preco() {
    return this.livrosForm.get('preco');
  }

  get paginas() {
    return this.livrosForm.get('paginas');
  }

  get imagem() {
    return this.livrosForm.get('imagem');
  }
}
