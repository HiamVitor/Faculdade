import { Component, OnInit } from "@angular/core";
import { FormControl, FormGroup, Validators } from "@angular/forms";
import { ActivatedRoute, Router } from "@angular/router";
import { ToastController } from "@ionic/angular";
import { AcessorioService } from "../acessorio.service";
import { Acessorio } from "../acessorio.model";

@Component({
  selector: 'app-acessorios-cadastro',
  templateUrl: './acessorios-cadastro.component.html',
  styleUrls: ['./acessorios-cadastro.component.scss'],
})

export class FormasPagtoCadastroComponent implements OnInit {
  acessorioId: number;
  acessorioForm: FormGroup;
  acessorio: Acessorio;
  constructor(
    private toastController: ToastController,
    private activatedRoute: ActivatedRoute,
    private acessorioService: AcessorioService,
    private router: Router
  ) {
    this.acessorio = {
      id: null,
      nome: '',
      descricao: '',
    };
    this.initializaFormulario(this.acessorio);
  }

  ngOnInit() {
    const id = this.activatedRoute.snapshot.paramMap.get('id');
    if (id) {
      this.acessorioId = parseInt(id);
      this.acessorioService.getAcessorio(this.acessorioId).subscribe((acessorio) => {
          this.acessorio = acessorio;
          this.initializaFormulario(this.acessorio);
        });
    }
  }

  initializaFormulario(acessorio: Acessorio) {
    this.acessorioForm = new FormGroup({
      nome: new FormControl(acessorio.nome, [
        Validators.required,
        Validators.maxLength(150),
      ]),
      descricao: new FormControl(acessorio.descricao, [
        Validators.required,
        Validators.maxLength(150),
      ])
    });
  }

  salvar() {
    const acessorio: Acessorio = {
      ...this.acessorioForm.value,
      id: this.acessorioId
    }
    this.acessorioService.salvar(acessorio).subscribe(
      () => this.router.navigate(['acessorios']), (erro) => {
        console.error(erro);
        this.toastController.create({
          message: `Não foi possível salvar o acessório ${acessorio.nome}`,
          duration: 5000,
          keyboardClose: true,
          color: 'danger'
        }).then(t => t.present());
      }
    );
  }

  get nome() {
    return this.acessorioForm.get('nome');
  }

  get descricao() {
    return this.acessorioForm.get('descricao');
  }
}
