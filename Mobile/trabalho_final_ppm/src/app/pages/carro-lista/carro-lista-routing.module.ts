import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { CarroListaPage } from './carro-lista.page';

const routes: Routes = [
  {
    path: '',
    component: CarroListaPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class CarroListaPageRoutingModule {}
