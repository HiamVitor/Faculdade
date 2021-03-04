var booleana = true;
console.log(booleana);

booleana = false;
console.log(booleana);
console.log(typeof(booleana));

booleana = !booleana;
console.log(booleana);

// ----------------------------

var numero = 1;
console.log(numero);
console.log(typeof(numero));

numero = -1;
console.log(numero);
console.log(typeof(numero));

numero = Math.PI;
console.log(numero);
console.log(typeof(numero));

var n1 = 10;
var n2 = 20;

console.log('soma: ', n1 + n2);
console.log('subtração: ', n1 - n2);
console.log('multiplicação: ', n1 * n2);
console.log('divisão: ', n1 / n2);

console.log('Potência 2 elevado a 5: ', Math.pow(2,5))
console.log('Raiz quadrada de 25: ', Math.sqrt(25))

var pi = Math.PI;
var numeroRandomico = Math.random() * 100;

console.log('Número randômico (Max. 100): ', numeroRandomico);
console.log('Número randômico (Max. 100): ', Math.floor(numeroRandomico));
console.log('Número randômico (Max. 100): ', Math.trunc(numeroRandomico));
console.log('Número randômico (Max. 100): ', Math.round(numeroRandomico));

//-------- 

var texto = 'texto';
console.log(texto);
console.log(typeof(texto));

texto = 'c';
console.log(texto);
console.log(typeof(texto));

texto = "texto";
console.log(texto);
console.log(typeof(texto));

console.log(texto.toUpperCase())
console.log(texto.toLowerCase())

texto = '            texto           ';
console.log(texto);
console.log(texto.trim());

texto = 'texto';
console.log(texto.startsWith('tex'));
console.log(texto.endsWith('to'));

console.log(texto.search('x'));
console.log(texto.search('a'));
console.log(texto.indexOf('x'));
console.log(texto.indexOf('a'));

console.log(texto.includes('x'));
console.log(texto.includes('a'));

console.log(texto.charAt(0));
console.log(texto.charAt(1));
console.log(texto[0]);
console.log(texto.concat(' texto'));
console.log(texto + ' ' + texto);

console.log(texto);
// Comentário de uma linha
/*
    Comentário de multiplas linhas
*/