import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { IonicModule } from '@ionic/angular';

import { CarrosPageRoutingModule } from './carros-routing.module';

import { CarrosPage } from './carros.page';
import { CarrosCadastroComponent } from './carros-cadastro/carros-cadastro.component';

@NgModule({
  imports: [
    FormsModule,
    ReactiveFormsModule,
    CommonModule,
    IonicModule,
    CarrosPageRoutingModule,
    HttpClientModule
  ],
  declarations: [CarrosPage, CarrosCadastroComponent]
})
export class CarrosPageModule {}
