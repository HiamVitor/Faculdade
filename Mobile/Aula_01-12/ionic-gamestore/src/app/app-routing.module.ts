import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'jogo-lista',
    pathMatch: 'full'
  },
  {
    path: 'jogo-cadastro',
    loadChildren: () => import('./jogo-cadastro/jogo-cadastro.module').then( m => m.JogoCadastroPageModule)
  },
  {
    path: 'jogo-cadastro/:codigo',
    loadChildren: () => import('./jogo-cadastro/jogo-cadastro.module').then( m => m.JogoCadastroPageModule)
  },
  {
    path: 'jogo-lista',
    loadChildren: () => import('./jogo-lista/jogo-lista.module').then( m => m.JogoListaPageModule)
  }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {}
