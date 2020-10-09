function somar() {
    // console.log(arguments);
    var soma = 0;
    for (var i = 0, l = arguments.length; i < l; i++) {
        soma += arguments[i];
    }
    return soma;
}

console.log(somar(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

