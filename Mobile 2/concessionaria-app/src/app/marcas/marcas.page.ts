import { Component, OnInit } from '@angular/core';
import { AlertController, ToastController } from '@ionic/angular';

import { Marca } from './marca.model';
import { MarcaService } from './marca.service';

@Component({
    selector: 'app-marcas',
    templateUrl: './marcas.page.html',
    styleUrls: ['./marcas.page.scss'],
})
export class MarcasPage implements OnInit {
    marcas: Marca[];

    constructor(
        private alertController: AlertController,
        private toastController: ToastController,
        private marcaService: MarcaService
    ) {}

    ionViewWillEnter() {
        this.listar();
    }

    ngOnInit() {
        this.listar();
    }

    listar() {
        this.marcaService.getMarcas().subscribe(
            (dados) => {
                this.marcas = dados;
            },
            (erro) => {
                console.error(erro);
            }
        );
    }

    confirmarExclusao(marca: Marca) {
        this.alertController
            .create({
                header: 'Confirmação de exclusão',
                message: `Deseja excluir o marca ${marca.nome}?`,
                buttons: [
                    {
                        text: 'Sim',
                        handler: () => this.excluir(marca),
                    },
                    {
                        text: 'Não',
                    },
                ],
            })
            .then((alerta) => alerta.present());
    }

    private excluir(marca: Marca) {
        this.marcaService.excluir(marca.id).subscribe(
            () => this.listar(),
            (erro) => {
                console.error(erro);
                this.toastController
                    .create({
                        message: `Não foi possível excluir o marca ${marca.nome}`,
                        duration: 5000,
                        keyboardClose: true,
                        color: 'danger',
                    })
                    .then((t) => t.present());
            }
        );
    }
}
