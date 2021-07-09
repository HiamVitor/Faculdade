import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastController } from '@ionic/angular';
import { Acessorio } from 'src/app/acessorios/acessorio.model';
import { AcessorioService } from 'src/app/acessorios/acessorio.service';
import { CondPagto } from 'src/app/condpagto/condpagto.model';
import { CondPagtoService } from 'src/app/condpagto/condpagto.service';
import { Marca } from 'src/app/marcas/marca.model';
import { MarcaService } from 'src/app/marcas/marca.service';

import { CarroService } from '../carro.service';
import { FormaPagto } from './../../formasPagto/formaPagto.model';
import { FormaPagtoService } from './../../formasPagto/formaPagto.service';
import { CarroViewModel } from './../carro.model';

@Component({
    selector: 'app-carros-cadastro',
    templateUrl: './carros-cadastro.component.html',
    styleUrls: ['./carros-cadastro.component.scss'],
})
export class CarrosCadastroComponent implements OnInit {
    carroId: number;
    carrosForm: FormGroup;

    marcasLista: Marca[];
    acessoriosLista: Acessorio[];
    formasLista: FormaPagto[];
    condsLista: CondPagto[];

    constructor(
        private toastController: ToastController,
        private activatedRoute: ActivatedRoute,
        private carroService: CarroService,
        private marcaService: MarcaService,
        private formaPagtoService: FormaPagtoService,
        private acessorioService: AcessorioService,
        private condPagtoServiceService: CondPagtoService,
        private router: Router
    ) {
        let carro = {
            id: null,
            modelo: '',
            ano: 0,
            marca: 0,
            preco: 0,
            imagem: '',
            placa: '',
            formas: [] as number[],
            acessorios: [] as number[],
            condicoes: [] as number[]
        };

        this.marcaService.getMarcas().subscribe(
            (dados) => {
                this.marcasLista = dados;
            },
            (erro) => {
                console.error(erro);
            }
        );
        this.formaPagtoService.getFormas().subscribe(
            (dados) => {
                this.formasLista = dados;
            },
            (erro) => {
                console.error(erro);
            }
        );
        this.acessorioService.getAcessorios().subscribe(
            (dados) => {
                this.acessoriosLista = dados;
            },
            (erro) => {
                console.error(erro);
            }
        );
        this.condPagtoServiceService.getCondsPagto().subscribe(
            (dados) => {
                this.condsLista = dados;
            },
            (erro) => {
                console.error(erro);
            }
        );
        this.initializaFormulario(carro);
    }

    ngOnInit() {
        const id = this.activatedRoute.snapshot.paramMap.get('id');
        if (id) {
            this.carroId = parseInt(id);
            this.carroService.getCarro(this.carroId).subscribe((carroViewModel) => {
                this.initializaFormulario(carroViewModel as any);
            });
        }
    }

    initializaFormulario(carro: CarroViewModel) {
        this.carrosForm = new FormGroup({
            modelo: new FormControl(carro.modelo, [
                Validators.required,
                Validators.minLength(3),
                Validators.maxLength(150),
            ]),
            placa: new FormControl(carro.placa, [
                Validators.required,
                Validators.minLength(7),
                Validators.maxLength(7),
            ]),
            marca: new FormControl(carro.marca, (control) => {
                return control.value
                    ? null
                    : ['O carro deve possuir pelo menos uma marca'];
            }),
            formas: new FormControl(carro.formas, (control) => {
                return !!control.value.length
                    ? null
                    : ['O carro deve possuir pelo menos uma forma de pagto'];
            }),
            acessorios: new FormControl(carro.acessorios),
            condicoes: new FormControl(carro.condicoes, (control) => {
                return !!control.value.length
                    ? null
                    : ['O carro deve possuir pelo menos uma forma de pagto'];
            }),
            preco: new FormControl(carro.preco),
            imagem: new FormControl(carro.imagem),
            ano: new FormControl(carro.ano),
        });
    }

    salvar() {
        const carro: CarroViewModel = {
            ...this.carrosForm.value,
            id: this.carroId,
        };
        this.carroService.salvar(carro).subscribe(
            () => this.router.navigate(['carros']),
            (response) => {
                console.error(response);
                this.toastController
                    .create({
                        message: response.error,
                        duration: 5000,
                        keyboardClose: true,
                        color: 'danger',
                    })
                    .then((t) => t.present());
            }
        );
    }

    get ano() {
        debugger
        return this.carrosForm.get('ano');
    }

    get modelo() {
        return this.carrosForm.get('modelo');
    }

    get placa() {
        return this.carrosForm.get('placa');
    }

    get preco() {
        return this.carrosForm.get('preco');
    }

    get imagem() {
        return this.carrosForm.get('imagem');
    }
}
