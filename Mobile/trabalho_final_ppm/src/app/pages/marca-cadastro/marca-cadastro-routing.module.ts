import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { MarcaCadastroPage } from './marca-cadastro.page';

const routes: Routes = [
  {
    path: '',
    component: MarcaCadastroPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class MarcaCadastroPageRoutingModule {}
