import { Component, OnInit } from '@angular/core';
import { AlertController, IonItemSliding, NavController, ToastController, ViewWillEnter } from '@ionic/angular';

import { Acessorio } from './acessorio.model';
import { AcessorioService } from './acessorio.service';

@Component({
    selector: 'app-forma-lista',
    templateUrl: './acessorio.page.html',
    styleUrls: ['./acessorio.page.scss'],
})
export class AcessorioPage implements OnInit {
    acessorios: Acessorio[];

    constructor(
        private acessorioService: AcessorioService,
        private alertController: AlertController,
        private toastController: ToastController,
        private navController: NavController,
    ) {}

    ionViewWillEnter() {
        this.listar();
    }

    ngOnInit() {
        this.listar();
    }

    listar() {
        this.acessorioService.getAcessorios().subscribe(
            (dados) => { this.acessorios = dados; },
            (erro) => { console.error(erro); }
        );
    }

    editar(acessorios: Acessorio, slidingItem: IonItemSliding) {
        this.navController.navigateForward([`acessorios/cadastro/${acessorios.id}`]);
        slidingItem.close();
    }

    confirmarExclusao(acessorio: Acessorio) {
        this.alertController.create({
            header: 'Confirmação de exclusão',
            message: `Deseja excluir o autor ${acessorio.nome}?`,
            buttons: [{
                text: 'Sim',
                handler: () => this.excluir(acessorio),
            }, {
                text: 'Não',
            }],
        }).then((alerta) => alerta.present());
    }

    private excluir(acessorio: Acessorio) {
        this.acessorioService.excluir(acessorio.id).subscribe(() => this.listar(),(erro) => {
                console.error(erro);
                this.toastController.create({
                    message: `Não foi possível excluir a forma de pagamento ${acessorio.nome}`,
                    duration: 5000,
                    keyboardClose: true,
                    color: 'danger',
                }).then((t) => t.present());
            }
        );
    }
}
