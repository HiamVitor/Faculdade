import { Component, OnInit } from "@angular/core";
import { FormControl, FormGroup, Validators } from "@angular/forms";
import { ActivatedRoute, Router } from "@angular/router";
import { ToastController } from "@ionic/angular";
import { CondPagtoService } from "../condpagto.service";
import { CondPagto } from "../condpagto.model";

@Component({
  selector: 'app-condspagto-cadastro',
  templateUrl: './condspagto-cadastro.component.html',
  styleUrls: ['./condspagto-cadastro.component.scss'],
})

export class CondPagtoPagtoCadastroComponent implements OnInit {
  condpagtoId: number;
  condpagtoForm: FormGroup;
  condpagto: CondPagto;
  constructor(
    private toastController: ToastController,
    private activatedRoute: ActivatedRoute,
    private condpagtoService: CondPagtoService,
    private router: Router
  ) {
    this.condpagto = {
      id: null,
      nome: '',
      descricao: '',
    };
    this.initializaFormulario(this.condpagto);
  }

  ngOnInit() {
    const id = this.activatedRoute.snapshot.paramMap.get('id');
    if (id) {
      this.condpagtoId = parseInt(id);
      this.condpagtoService.getCondPagto(this.condpagtoId).subscribe((condpagto) => {
          this.condpagto = condpagto;
          this.initializaFormulario(this.condpagto);
        });
    }
  }

  initializaFormulario(condpagto: CondPagto) {
    this.condpagtoForm = new FormGroup({
      nome: new FormControl(condpagto.nome, [
        Validators.required,
        Validators.maxLength(150),
      ]),
      descricao: new FormControl(condpagto.descricao, [
        Validators.required,
        Validators.maxLength(150),
      ])
    });
  }

  salvar() {
    const condpagto: CondPagto = {
      ...this.condpagtoForm.value,
      id: this.condpagtoId
    }
    this.condpagtoService.salvar(condpagto).subscribe(
      () => this.router.navigate(['condsPagto']), (erro) => {
        console.error(erro);
        this.toastController.create({
          message: `Não foi possível salvar o acessório ${condpagto.nome}`,
          duration: 5000,
          keyboardClose: true,
          color: 'danger'
        }).then(t => t.present());
      }
    );
  }

  get nome() {
    return this.condpagtoForm.get('nome');
  }

  get descricao() {
    return this.condpagtoForm.get('descricao');
  }
}
