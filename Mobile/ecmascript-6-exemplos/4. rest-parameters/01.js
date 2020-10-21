function somar(array) {
    var soma = 0;
    for (var i = 0, l = array.length; i < l; i++) {
        soma += array[i];
    }
    return soma;
}

const arrayNumeros = [1, 2, 3, 4, 5];

console.log(somar(arrayNumeros));
