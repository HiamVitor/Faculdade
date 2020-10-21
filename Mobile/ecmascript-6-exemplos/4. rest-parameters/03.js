function somar(...array) {

    console.log(array);
    console.log(typeof(array));
    
    var soma = 0;
    for (var i = 0, l = array.length; i < l; i++) {
        soma += array[i];
    }
    return soma;
}

console.log(somar(1, 2, 3, 4, 5));

