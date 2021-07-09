import { Component, OnInit } from '@angular/core';
import { AlertController, IonItemSliding, NavController, ToastController, ViewWillEnter } from '@ionic/angular';

import { CondPagto } from './condpagto.model';
import { CondPagtoService } from './condpagto.service';

@Component({
    selector: 'app-condpagto-lista',
    templateUrl: './condpagto.page.html',
    styleUrls: ['./condpagto.page.scss'],
})
export class CondPagtoPage implements OnInit {
    condpagtos: CondPagto[];

    constructor(
        private condpagtoService: CondPagtoService,
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
        this.condpagtoService.getCondsPagto().subscribe(
            (dados) => { this.condpagtos = dados; },
            (erro) => { console.error(erro); }
        );
    }

    editar(condpagtos: CondPagto, slidingItem: IonItemSliding) {
        this.navController.navigateForward([`condsPagto/cadastro/${condpagtos.id}`]);
        slidingItem.close();
    }

    confirmarExclusao(condpagto: CondPagto) {
        this.alertController.create({
            header: 'Confirmação de exclusão',
            message: `Deseja excluir o autor ${condpagto.nome}?`,
            buttons: [{
                text: 'Sim',
                handler: () => this.excluir(condpagto),
            }, {
                text: 'Não',
            }],
        }).then((alerta) => alerta.present());
    }

    private excluir(condpagto: CondPagto) {
        this.condpagtoService.excluir(condpagto.id).subscribe(() => this.listar(),(erro) => {
                console.error(erro);
                this.toastController.create({
                    message: `Não foi possível excluir a forma de pagamento ${condpagto.nome}`,
                    duration: 5000,
                    keyboardClose: true,
                    color: 'danger',
                }).then((t) => t.present());
            }
        );
    }
}
