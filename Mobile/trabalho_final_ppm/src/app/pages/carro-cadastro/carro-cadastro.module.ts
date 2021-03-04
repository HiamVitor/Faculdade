import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { CarroCadastroPageRoutingModule } from './carro-cadastro-routing.module';

import { CarroCadastroPage } from './carro-cadastro.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    CarroCadastroPageRoutingModule
  ],
  declarations: [CarroCadastroPage]
})
export class CarroCadastroPageModule {}
