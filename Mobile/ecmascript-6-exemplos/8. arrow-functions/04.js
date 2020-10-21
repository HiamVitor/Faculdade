// Objeto literal
const pessoa1 = {
    nome: "João",
    imprimirNome() {
        console.log(this.nome);
    }
};

const pessoa2 = new Object();
pessoa2.nome = 'Maria';
pessoa2.idade = 30;
pessoa2.rg = 1234567;
pessoa2.imprimirNome = () => {
    console.log(this.nome);
};

pessoa1.imprimirNome();
pessoa2.imprimirNome();