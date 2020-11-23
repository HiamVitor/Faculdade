var pessoa = {
    nome: "João",
    nomeMeio: "Antônio",
    sobrenome: "da Silva"
};

function imprimirHelloWorld( {nome} ) {
    console.log(`Hello World ${nome}!`);
}

function imprimirPadraoAmericano( {sobrenome,nome} ) {
    console.log(`${sobrenome}, ${nome}`);    
}

imprimirHelloWorld(pessoa);
imprimirPadraoAmericano(pessoa);