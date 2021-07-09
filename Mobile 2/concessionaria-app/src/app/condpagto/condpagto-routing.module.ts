import { CondPagtoPage } from './condpagto.page';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CondPagtoPagtoCadastroComponent } from './condpagto-cadastro/condspagto-cadastro.component';

const routes: Routes = [
  {
    path: '',
    component: CondPagtoPage
  },
  {
    path: 'cadastro',
    component: CondPagtoPagtoCadastroComponent
  },
  {
    path: 'cadastro/:id',
    component: CondPagtoPagtoCadastroComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class CondPagtoPageRoutingModule {}
