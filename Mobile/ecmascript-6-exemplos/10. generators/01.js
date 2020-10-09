function* generatorFunction() {
    yield console.log("passo 1");
    yield console.log("passo 2");
    yield console.log("passo 3");
    console.log("acabou a execução");
}

var generator = generatorFunction();
// meuGenerator.next();
// meuGenerator.next();
// meuGenerator.next();
// meuGenerator.next();