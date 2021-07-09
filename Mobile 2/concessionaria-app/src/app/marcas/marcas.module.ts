import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { IonicModule } from '@ionic/angular';

import { MarcasPageRoutingModule } from './marcas-routing.module';

import { MarcasPage } from './marcas.page';
import { MarcasCadastroComponent } from './marcas-cadastro/marcas-cadastro.component';

@NgModule({
  imports: [
    FormsModule,
    ReactiveFormsModule,
    CommonModule,
    IonicModule,
    MarcasPageRoutingModule,
    HttpClientModule
  ],
  declarations: [MarcasPage, MarcasCadastroComponent]
})
export class MarcasPageModule {}
