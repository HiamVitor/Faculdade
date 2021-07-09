import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { IonicModule } from '@ionic/angular';
import { LivrosCadastroComponent } from './livros-cadastro/livros-cadastro.component';
import { LivrosPageRoutingModule } from './livros-routing.module';
import { LivrosPage } from './livros.page';

@NgModule({
  imports: [
    FormsModule,
    ReactiveFormsModule,
    CommonModule,
    IonicModule,
    LivrosPageRoutingModule,
    HttpClientModule,
  ],
  declarations: [LivrosPage, LivrosCadastroComponent],
})
export class LivrosPageModule {}
