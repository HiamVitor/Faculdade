import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { JogoCadastroPageRoutingModule } from './jogo-cadastro-routing.module';

import { JogoCadastroPage } from './jogo-cadastro.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    JogoCadastroPageRoutingModule
  ],
  declarations: [JogoCadastroPage]
})
export class JogoCadastroPageModule {}
