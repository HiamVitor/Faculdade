function* generatorFunction() {
    let x = yield "passo 1";
    let y = yield "passo 2";
    let z = yield "passo 3";
    return `acabou a execução: ${x+y+z}`
}

var meuGenerator = generatorFunction();
console.log(meuGenerator.next());
console.log(meuGenerator.next(1));
console.log(meuGenerator.next(2));
console.log(meuGenerator.next(3));