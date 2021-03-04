import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { LivroListaPage } from './livro-lista.page';

const routes: Routes = [
  {
    path: '',
    component: LivroListaPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class LivroListaPageRoutingModule {}
