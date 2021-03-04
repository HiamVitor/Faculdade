import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'carro-lista',
    pathMatch: 'full'
  },
  {
    path: 'carro-lista',
    loadChildren: () => import('./pages/carro-lista/carro-lista.module').then( m => m.CarroListaPageModule)
  },
  {
    path: 'carro-cadastro',
    loadChildren: () => import('./pages/carro-cadastro/carro-cadastro.module').then( m => m.CarroCadastroPageModule)
  },
  {
    path: 'carro-cadastro/:codigo',
    loadChildren: () => import('./pages/carro-cadastro/carro-cadastro.module').then( m => m.CarroCadastroPageModule)
  },
  {
    path: 'marca-cadastro',
    loadChildren: () => import('./pages/marca-cadastro/marca-cadastro.module').then( m => m.MarcaCadastroPageModule)
  },
  {
    path: 'marca-cadastro/:codigo',
    loadChildren: () => import('./pages/marca-cadastro/marca-cadastro.module').then( m => m.MarcaCadastroPageModule)
  },
  {
    path: 'marca-lista',
    loadChildren: () => import('./pages/marca-lista/marca-lista.module').then( m => m.MarcaListaPageModule)
  }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {}
