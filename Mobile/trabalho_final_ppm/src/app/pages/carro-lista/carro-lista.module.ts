import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { CarroListaPageRoutingModule } from './carro-lista-routing.module';

import { CarroListaPage } from './carro-lista.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    CarroListaPageRoutingModule
  ],
  declarations: [CarroListaPage]
})
export class CarroListaPageModule {}
