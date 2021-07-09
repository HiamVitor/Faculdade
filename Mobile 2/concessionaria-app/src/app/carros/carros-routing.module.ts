import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CarrosCadastroComponent } from './carros-cadastro/carros-cadastro.component';
import { CarrosPage } from './carros.page';

const routes: Routes = [
  {
    path: '',
    component: CarrosPage
  },
  {
    path: 'cadastro',
    component: CarrosCadastroComponent
  },
  {
    path: 'cadastro/:id',
    component: CarrosCadastroComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class CarrosPageRoutingModule {}
