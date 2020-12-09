import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';

const routes: Routes = [
    {
        path: '',
        redirectTo: 'livro-lista',
        pathMatch: 'full',
    },
    {
        path: 'livro-lista',
        loadChildren: () => import('./livro-lista/livro-lista.module').then((m) => m.LivroListaPageModule),
    },
];

@NgModule({
    imports: [RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })],
    exports: [RouterModule],
})
export class AppRoutingModule {}
