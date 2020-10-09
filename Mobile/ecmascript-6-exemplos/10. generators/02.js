function* generatorFunction() {
    yield "passo 1"
    yield "passo 2"
    yield "passo 3"
    return "acabou a execução"
}

var generator = generatorFunction();
console.log(generator.next());
console.log(generator.next());
console.log(generator.next());
console.log(generator.next());