var pessoa = {
    nome: "João",
    nomeMeio: "Antônio",
    sobrenome: "da Silva"
};

function imprimirHelloWorld({nome:n}) {
    console.log(`Hello World ${n}!`);
}

function imprimirPadraoAmericano({sobrenome:s,nome:n}) {
    console.log(`${s}, ${n}`);    
}

imprimirHelloWorld(pessoa);
imprimirPadraoAmericano(pessoa);