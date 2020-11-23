let frutas = ["maça", "laranja", "pêra"];
let maisFrutas = ["uva", "pêssego", "goiaba"];

let todasFrutas = [frutas, maisFrutas];
console.log(todasFrutas);

todasFrutas = [...frutas, ...maisFrutas];
console.log(todasFrutas);

todasFrutas = [frutas[0], frutas[1], frutas[2], maisFrutas[0], maisFrutas[1], maisFrutas[2]];
console.log(todasFrutas);

