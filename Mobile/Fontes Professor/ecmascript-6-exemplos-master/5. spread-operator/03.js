let numeros = [1,2,3];

function soma(n1, n2, n3) {
    return n1 + n2 + n3;    
}

console.log(soma(numeros));
console.log(soma(numeros[0], numeros[1], numeros[2]));
console.log(soma(...numeros));

