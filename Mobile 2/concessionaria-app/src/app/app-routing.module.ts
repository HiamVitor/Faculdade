import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full'
  },
  {
    path: 'home',
    loadChildren: () => import('./home/home.module').then( m => m.HomePageModule)
  },
  {
    path: 'carros',
    loadChildren: () => import('./carros/carros.module').then( m => m.CarrosPageModule)
  },
  {
    path: 'marcas',
    loadChildren: () => import('./marcas/marcas.module').then( m => m.MarcasPageModule)
  },
  {
    path: 'formas',
    loadChildren: () => import('./formasPagto/formaPagto.module').then( m => m.FormaPagtoPageModule)
  },
  {
    path: 'acessorios',
    loadChildren: () => import('./acessorios/acessorio.module').then( m => m.AcessorioPageModule)
  },
  {
    path: 'condsPagto',
    loadChildren: () => import('./condpagto/condpagto.module').then( m => m.CondPagtoPageModule)
  }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {}
