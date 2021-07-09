import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ActionSheetController, AlertController, ToastController } from '@ionic/angular';
import { Marca } from '../marca.model';
import { MarcaService } from '../marca.service';
import { Pais } from '../pais.enum';

@Component({
  selector: 'app-marcas-cadastro',
  templateUrl: './marcas-cadastro.component.html',
  styleUrls: ['./marcas-cadastro.component.scss'],
})

export class MarcasCadastroComponent implements OnInit {
  marcaId: number;
  marcasForm: FormGroup;

  paisSelecionado = {
    sigla: '',
    nome: ''
  };

  async pesquisaPaisPrompt() {
    const alert = await this.alertController.create({
      header: 'Pesquisa',
      inputs: [{
        name: 'termoPesquisa',
        type: 'text',
        placeholder: 'Termo de pesquisa'
      }],
      buttons: [{
        text: 'Cancelar',
        role: 'cancel'
      }, {
        text: 'Ok',
        handler: (data: any) => {
          this.escolherPais(data.termoPesquisa);
        }
      }]
    });

    await alert.present();
  }

  async escolherPais(pesquisa) {
    let flagButtons = [],
        listaPaises = Object.keys(Pais).map((pais) => {
          return {
            text: Pais[pais],
            icon: `assets/icon/flags/${pais}.svg`,
            handler: () => {
              this.paisSelecionado.sigla = pais;
              this.paisSelecionado.nome = Pais[pais];
            }
          }
        });

    if(pesquisa) listaPaises = listaPaises.filter(botoes => botoes.text.toLowerCase().includes(pesquisa.toLowerCase()));
    flagButtons = listaPaises;
    flagButtons.push({
      text: 'Cancel',
      icon: 'close',
      role: 'cancel'
    });
    flagButtons.unshift({
      text: 'Pesquisar',
      icon: 'search',
      handler: () => {
        this.pesquisaPaisPrompt();
      }
    });
    
    const actionSheet = await this.actionSheetController.create({ buttons: flagButtons });
    await actionSheet.present();
  }

  constructor(
    private toastController: ToastController,
    public actionSheetController: ActionSheetController,
    public alertController: AlertController,
    private activatedRoute: ActivatedRoute,
    private marcaService: MarcaService,
    private router: Router
  ) {
    let marca = {
      id: null,
      nome: '',
      pais: '',
    };
    this.initializaFormulario(marca);
  }

  ngOnInit() {
    const id = this.activatedRoute.snapshot.paramMap.get('id');
    if (id) {
      this.marcaId = parseInt(id);
      this.marcaService
        .getMarca(this.marcaId)
        .subscribe((marca) => {
          this.initializaFormulario(marca);
        });
    }
  }

  initializaFormulario(marca: Marca) {
    this.paisSelecionado.nome = Pais[marca.pais];
    this.paisSelecionado.sigla = marca.pais;
    this.marcasForm = new FormGroup({
      nome: new FormControl(marca.nome, [
        Validators.required,
        Validators.maxLength(150),
      ]),
      pais: new FormControl(marca.pais, Validators.required)
    })
  }

  salvar() {
    const marca: Marca = {
      ...this.marcasForm.value,
      id: this.marcaId
    }
    this.marcaService.salvar(marca).subscribe(
      () => this.router.navigate(['marcas']),
      (erro) => {
        console.error(erro);
        this.toastController.create({
          message: `Não foi possível salvar o marca ${marca.nome}`,
          duration: 5000,
          keyboardClose: true,
          color: 'danger'
        }).then(t => t.present());
      }
    );
  }

  get nome() {
    return this.marcasForm.get('nome');
  }
}
