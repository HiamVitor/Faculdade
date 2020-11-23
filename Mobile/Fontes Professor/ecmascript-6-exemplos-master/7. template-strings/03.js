
function helloWorld(nome = '', sobrenome = '') {
    console.log(`Hello world${nome ? ', ': ''}${nome}${(sobrenome?' ':'')}${sobrenome}!`);
}

helloWorld('José', 'de Souza');
helloWorld('Felipe');
helloWorld(undefined, 'Silva');