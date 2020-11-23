import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HelloWorldComponent } from './hello-world/hello-world.component';
import { FormsModule } from '@angular/forms';
import { DataHoraComponent } from './data-hora/data-hora.component';
import { IncrementarDecrementarComponent } from './incrementar-decrementar/incrementar-decrementar.component';
import { LivrosComponent } from './livros/livros.component';

@NgModule({
  declarations: [
    AppComponent,
    HelloWorldComponent,
    DataHoraComponent,
    IncrementarDecrementarComponent,
    LivrosComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
