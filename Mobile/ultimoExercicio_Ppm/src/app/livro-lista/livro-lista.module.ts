import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { LivroListaPageRoutingModule } from './livro-lista-routing.module';

import { LivroListaPage } from './livro-lista.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    LivroListaPageRoutingModule
  ],
  declarations: [LivroListaPage]
})
export class LivroListaPageModule {}
