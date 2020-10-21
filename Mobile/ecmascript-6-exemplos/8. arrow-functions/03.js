// Objeto literal
var pessoa1 = {
    nome: "João",
    imprimirNome: function() {
        console.log(this.nome);
    }
};

var pessoa2 = new Object();
pessoa2.nome = 'Maria';
pessoa2.idade = 30;
pessoa2.rg = 1234567;
pessoa2.imprimirNome = function() {
    console.log(this.nome);
};

pessoa1.imprimirNome();
pessoa2.imprimirNome();