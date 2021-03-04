import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { MarcaListaPageRoutingModule } from './marca-lista-routing.module';

import { MarcaListaPage } from './marca-lista.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    MarcaListaPageRoutingModule
  ],
  declarations: [MarcaListaPage]
})
export class MarcaListaPageModule {}
