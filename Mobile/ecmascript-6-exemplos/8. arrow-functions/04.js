const p1 = {
    nome: "João",
    imprimirNome() {
        console.log(this.nome);
    }
};

const p2 = new Object();
p2.nome = 'Maria';
p2.imprimirNome = () => {
    console.log(this.nome);
};
p2.idade = 30;

p1.imprimirNome();
p2.imprimirNome();