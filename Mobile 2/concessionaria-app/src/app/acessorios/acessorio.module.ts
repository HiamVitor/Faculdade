import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { IonicModule } from '@ionic/angular';

import { AcessorioPageRoutingModule } from './acessorio-routing.module';

import { AcessorioPage } from './acessorio.page';
import { FormasPagtoCadastroComponent } from './acessorio-cadastro/acessorios-cadastro.component';

@NgModule({
  imports: [
    FormsModule,
    ReactiveFormsModule,
    CommonModule,
    IonicModule,
    AcessorioPageRoutingModule,
    HttpClientModule
  ],
  declarations: [AcessorioPage, FormasPagtoCadastroComponent]
})
export class AcessorioPageModule {}
