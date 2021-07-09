import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { IonicModule } from '@ionic/angular';

import { CondPagtoPageRoutingModule } from './condpagto-routing.module';

import { CondPagtoPage } from './condpagto.page';
import { CondPagtoPagtoCadastroComponent } from './condpagto-cadastro/condspagto-cadastro.component';

@NgModule({
  imports: [
    FormsModule,
    ReactiveFormsModule,
    CommonModule,
    IonicModule,
    CondPagtoPageRoutingModule,
    HttpClientModule
  ],
  declarations: [CondPagtoPage, CondPagtoPagtoCadastroComponent]
})
export class CondPagtoPageModule {}
