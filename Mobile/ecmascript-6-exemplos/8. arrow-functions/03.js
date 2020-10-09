var p1 = {
    nome: "João",
    imprimirNome: function() {
        console.log(this.nome);
    }
};

var p2 = new Object();
p2.nome = 'Maria';
p2.imprimirNome = function() {
    console.log(this.nome);
};
p2.idade = 30;

p1.imprimirNome();
p2.imprimirNome();