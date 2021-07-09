import { FormaPagto } from './../formasPagto/formaPagto.model';
import { FormaPagtoService } from '../formasPagto/formaPagto.service';
import { Component, OnInit } from '@angular/core';
import { AlertController, NavController } from '@ionic/angular';
import { IonItemSliding } from '@ionic/angular';
import { MarcaService } from '../marcas/marca.service';
import { CarroService } from './carro.service';
import { CarroViewModel } from './carro.model';

@Component({
  selector: 'app-carros',
  templateUrl: './carros.page.html',
  styleUrls: ['./carros.page.scss'],
})
export class CarrosPage implements OnInit {

  public carros: any[];
  marcaNome: string;


  constructor(
    private carrosService: CarroService,
    private marcaService: MarcaService,
    private formaPagtoService: FormaPagtoService,
    private alertController: AlertController,
    private navController: NavController,
  ) { }

  ionViewWillEnter() {
    this.listar();
  }

  ngOnInit() {
    this.listar();
  }

  listar() {
    this.carrosService.getCarros().subscribe((carrosViewmodel) => {
      let carros: any[] = [];

      carrosViewmodel.forEach(carroViewmodel => {
        let carro: any;
        let carroSemFormas: any = Object.assign({}, carroViewmodel);
        carroSemFormas.formas = [] as FormaPagto[];
        carro = carroSemFormas;

        /*this.formaPagtoService
          .getForma(carroViewmodel.formas)
          .subscribe((forma) => {
            if(carro.formas.length) carro.formas.push(...(forma as any));
          });*/

        this.marcaService.getMarca(carro.marca).subscribe((marca)=>{
          carro.marcaNome = marca.nome;
        });
        carros.push(carro);
      });
      this.carros = carros;
    });
  }

  async exclusao(carros: CarroViewModel, slidingItem: IonItemSliding) {
    const alert = await this.alertController.create({
      header: 'Confirmação de exclusão',
      message: `Deseja excluir o carros ${carros.modelo}?`,
      buttons: [{
        text: 'Sim',
        handler: () => this.excluir(carros)
      }, {
        text: 'Não',
        handler: () => slidingItem.close()
      }]
    });
    alert.present();
  }

  excluir(carros:CarroViewModel) {
    this.carrosService.excluir(carros).subscribe(() => this.listar());
  }

  editar(carros: CarroViewModel, slidingItem: IonItemSliding) {
    this.navController.navigateForward([`carros/cadastro/${carros.id}`]);
    slidingItem.close();
  }
}
