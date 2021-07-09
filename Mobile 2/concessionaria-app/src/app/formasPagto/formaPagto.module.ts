import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { IonicModule } from '@ionic/angular';

import { FormaPagtoPageRoutingModule } from './formaPagto-routing.module';

import { FormaPagtoPage } from './formaPagto.page';
import { FormasPagtoCadastroComponent } from './formaPagto-cadastro/formasPagto-cadastro.component';

@NgModule({
  imports: [
    FormsModule,
    ReactiveFormsModule,
    CommonModule,
    IonicModule,
    FormaPagtoPageRoutingModule,
    HttpClientModule
  ],
  declarations: [FormaPagtoPage, FormasPagtoCadastroComponent]
})
export class FormaPagtoPageModule {}
