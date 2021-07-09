import { FormaPagtoPage } from './formaPagto.page';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FormasPagtoCadastroComponent } from './formaPagto-cadastro/formasPagto-cadastro.component';

const routes: Routes = [
  {
    path: '',
    component: FormaPagtoPage
  },
  {
    path: 'cadastro',
    component: FormasPagtoCadastroComponent
  },
  {
    path: 'cadastro/:id',
    component: FormasPagtoCadastroComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class FormaPagtoPageRoutingModule {}
