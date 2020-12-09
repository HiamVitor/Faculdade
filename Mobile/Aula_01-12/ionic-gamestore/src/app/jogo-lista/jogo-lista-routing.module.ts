import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { JogoListaPage } from './jogo-lista.page';

const routes: Routes = [
  {
    path: '',
    component: JogoListaPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class JogoListaPageRoutingModule {}
