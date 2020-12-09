import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { JogoListaPageRoutingModule } from './jogo-lista-routing.module';

import { JogoListaPage } from './jogo-lista.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    JogoListaPageRoutingModule
  ],
  declarations: [JogoListaPage]
})
export class JogoListaPageModule {}
