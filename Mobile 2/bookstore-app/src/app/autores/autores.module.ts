import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { IonicModule } from '@ionic/angular';
import { AutoresCadastroComponent } from './autores-cadastro/autores-cadastro.component';
import { AutoresPageRoutingModule } from './autores-routing.module';
import { AutoresPage } from './autores.page';

@NgModule({
  imports: [
    FormsModule,
    ReactiveFormsModule,
    CommonModule,
    IonicModule,
    AutoresPageRoutingModule,
    HttpClientModule,
  ],
  declarations: [AutoresPage, AutoresCadastroComponent],
})
export class AutoresPageModule {}
