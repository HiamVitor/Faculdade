import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MarcasCadastroComponent } from './marcas-cadastro/marcas-cadastro.component';

import { MarcasPage } from './marcas.page';

const routes: Routes = [
  {
    path: '',
    component: MarcasPage
  },
  {
    path: 'cadastro',
    component: MarcasCadastroComponent
  },
  {
    path: 'edicao/:id',
    component: MarcasCadastroComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class MarcasPageRoutingModule {}
