// // ES 5
// let array = new Array();
// // let array = []; // forma literal
// array.push('A', 'B', 'C', 'D');

// console.log(array);
// console.log(array.length); // tamanho do array
// console.log(array.indexOf('D')); // índice do elemento
// console.log(array.indexOf('E')); // -1 quando não está presente
// console.log(array.indexOf('E') !== -1);
// array.splice(array.indexOf('C'), 1); // retorna uma parte do array
// console.log(array);
// console.log(array.pop()); // retira o último elemento do array e o retorno
// console.log(array);
// array.unshift(0); // insere o elemento do parâmetro no começo do array
// console.log(array);

//  ES6
let set = new Set();
set.add('A');
set.add('B');
set.add('C');
set.add('A');
console.log(set);

set.forEach(function(e) {
    console.log(e);
});

set.forEach(e => console.log(e));

console.log(set.size);
console.log(set.has('A'));
console.log(set.has('D'));
set.delete('B');
console.log(set);
set.clear();
console.log(set);
