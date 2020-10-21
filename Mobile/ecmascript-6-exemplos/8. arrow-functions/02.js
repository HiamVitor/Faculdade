// ES 5
var helloWorld1 = function(nome) {
    return "Hello World, " + nome + "!";
};

function helloWorld2(nome) {
    return "Hello World, " + nome + "!";
}

// ES 6
const helloWorld3 = (nome) => {
    return `Hello World, ${nome}!`;
}

const helloWorld4 = (nome) => `Hello World, ${nome}!`;

console.log(helloWorld1("Anderson"));
console.log(helloWorld2("Anderson"));
console.log(helloWorld3("Anderson"));
console.log(helloWorld4("Anderson"));
