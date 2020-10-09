function dividir(numero1, numero2) {
    if(numero2 === undefined) {
        throw new Error("O divisor é obrigatório");
    }
    return numero1 / numero2;
}

console.log(dividir(4,2));
console.log(dividir(4));

