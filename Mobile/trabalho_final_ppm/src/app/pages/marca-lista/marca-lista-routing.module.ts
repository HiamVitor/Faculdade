import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { MarcaListaPage } from './marca-lista.page';

const routes: Routes = [
  {
    path: '',
    component: MarcaListaPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class MarcaListaPageRoutingModule {}
