import { Component, OnInit } from '@angular/core';
import { Autor } from './autor';

import { Livro } from './livro';

@Component({
  selector: 'app-livros',
  templateUrl: './livros.component.html',
  styleUrls: ['./livros.component.css']
})
export class LivrosComponent implements OnInit {

  livros: Livro[];

  constructor() { 
    // let livro1 = new Livro('JavaScript: O guia definitivo', [ new Autor('David', 'Flanagan') ]); 
    // let livro2 = new Livro('O melhor do JavaScript', [ new Autor('Douglas', 'Cockford') ]);
    // let livro3 = new Livro('JavaScript Design Patterns', [ new Autor('Addy', 'Osmani') ]);
    
    // this.livros = [ livro1, livro2, livro3 ];

    this.livros = [
      new Livro('JavaScript: O guia definitivo', [ new Autor('David', 'Flanagan') ], 0),
      new Livro('O melhor do JavaScript', [ new Autor('Douglas', 'Cockford'), new Autor('Segundo', 'Autor') ], 1),
      new Livro('JavaScript Design Patterns', [ new Autor('Addy', 'Osmani'), new Autor('Segundo', 'Autor'), new Autor('Terceiro', 'Autor') ], 2)
    ];  
  }

  ngOnInit(): void {
  }

}
