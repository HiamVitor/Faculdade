import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { MarcaCadastroPageRoutingModule } from './marca-cadastro-routing.module';

import { MarcaCadastroPage } from './marca-cadastro.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    MarcaCadastroPageRoutingModule
  ],
  declarations: [MarcaCadastroPage]
})
export class MarcaCadastroPageModule {}
