function somar(...parametros) {
    let soma = 0;
    for (const p of parametros) {
        soma += p;
    }
    return soma;
}

console.log(`Soma: ${ somar(2,4,6,8,10) }`);

console.log(`Soma: ${ somar(2,4,6,8,10) > 20 }`);

console.log(`Soma: ${ somar(2,4,6,8) < 20 }`);
