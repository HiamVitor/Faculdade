import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { CarroCadastroPage } from './carro-cadastro.page';

const routes: Routes = [
  {
    path: '',
    component: CarroCadastroPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class CarroCadastroPageRoutingModule {}
