import { Component } from '@angular/core';
@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styleUrls: ['app.component.scss'],
})
export class AppComponent {
  public menus = [
    { title: 'Home', url: '/home', icon: 'home' },
    { title: 'Carros', url: '/carros', icon: 'car-sport' },
    { title: 'Marcas', url: '/marcas', icon: 'apps' },
    { title: 'Formas de pagamento', url: '/formas', icon: 'albums' },
    { title: 'Acessórios', url: '/acessorios', icon: 'cube' },
    { title: 'Condições de pagamento', url: '/condsPagto', icon: 'cash' },
  ];
  constructor() {}
}
