import { Component, OnInit } from '@angular/core';
import { AlertController, IonItemSliding, NavController, ToastController, ViewWillEnter } from '@ionic/angular';

import { FormaPagto } from './formaPagto.model';
import { FormaPagtoService } from './formaPagto.service';

@Component({
    selector: 'app-forma-lista',
    templateUrl: './formaPagto.page.html',
    styleUrls: ['./formaPagto.page.scss'],
})
export class FormaPagtoPage implements OnInit {
    formas: FormaPagto[];

    constructor(
        private formaPagtoService: FormaPagtoService,
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
        this.formaPagtoService.getFormas().subscribe(
            (dados) => { this.formas = dados; },
            (erro) => { console.error(erro); }
        );
    }

    editar(formas: FormaPagto, slidingItem: IonItemSliding) {
        this.navController.navigateForward([`formas/cadastro/${formas.id}`]);
        slidingItem.close();
    }

    confirmarExclusao(formaPagto: FormaPagto) {
        this.alertController.create({
            header: 'Confirmação de exclusão',
            message: `Deseja excluir o autor ${formaPagto.nome}?`,
            buttons: [{
                text: 'Sim',
                handler: () => this.excluir(formaPagto),
            }, {
                text: 'Não',
            }],
        }).then((alerta) => alerta.present());
    }

    private excluir(formaPagto: FormaPagto) {
        this.formaPagtoService.excluir(formaPagto.id).subscribe(() => this.listar(),(erro) => {
                console.error(erro);
                this.toastController.create({
                    message: `Não foi possível excluir a forma de pagamento ${formaPagto.nome}`,
                    duration: 5000,
                    keyboardClose: true,
                    color: 'danger',
                }).then((t) => t.present());
            }
        );
    }
}
