import { Component, OnInit } from "@angular/core";
import { FormControl, FormGroup, Validators } from "@angular/forms";
import { ActivatedRoute, Router } from "@angular/router";
import { ToastController } from "@ionic/angular";
import { FormaPagtoService } from "../formaPagto.service";
import { FormaPagto } from "../formaPagto.model";

@Component({
  selector: 'app-marcas-cadastro',
  templateUrl: './formasPagto-cadastro.component.html',
  styleUrls: ['./formasPagto-cadastro.component.scss'],
})

export class FormasPagtoCadastroComponent implements OnInit {
  formaPagtoId: number;
  formaForm: FormGroup;
  formaPagto: FormaPagto;
  constructor(
    private toastController: ToastController,
    private activatedRoute: ActivatedRoute,
    private formaPagtoService: FormaPagtoService,
    private router: Router
  ) {
    this.formaPagto = {
      id: null,
      nome: '',
      descricao: '',
    };
    this.initializaFormulario(this.formaPagto);
  }

  ngOnInit() {
    const id = this.activatedRoute.snapshot.paramMap.get('id');
    if (id) {
      this.formaPagtoId = parseInt(id);
      this.formaPagtoService.getForma(this.formaPagtoId).subscribe((fp) => {
          this.formaPagto = fp;
          this.initializaFormulario(this.formaPagto);
        });
    }
  }

  initializaFormulario(fp: FormaPagto) {
    this.formaForm = new FormGroup({
      nome: new FormControl(fp.nome, [
        Validators.required,
        Validators.maxLength(150),
      ]),
      descricao: new FormControl(fp.descricao, [
        Validators.required,
        Validators.maxLength(150),
      ])
    });
  }

  salvar() {
    const formaPagto: FormaPagto = {
      ...this.formaForm.value,
      id: this.formaPagtoId
    }
    this.formaPagtoService.salvar(formaPagto).subscribe(
      () => this.router.navigate(['formas']), (erro) => {
        console.error(erro);
        this.toastController.create({
          message: `Não foi possível salvar o marca ${formaPagto.nome}`,
          duration: 5000,
          keyboardClose: true,
          color: 'danger'
        }).then(t => t.present());
      }
    );
  }

  get nome() {
    return this.formaForm.get('nome');
  }

  get descricao() {
    return this.formaForm.get('descricao');
  }
}
