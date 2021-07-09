import { AcessorioPage } from './acessorio.page';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FormasPagtoCadastroComponent } from './acessorio-cadastro/acessorios-cadastro.component';

const routes: Routes = [
  {
    path: '',
    component: AcessorioPage
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
export class AcessorioPageRoutingModule {}
