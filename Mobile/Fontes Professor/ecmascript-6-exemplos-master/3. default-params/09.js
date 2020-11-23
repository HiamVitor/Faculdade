function imprimir(nome = '', sobrenome = '') {
    console.log(nome, ' ', sobrenome);
}

imprimir('João', 'da Silva');

imprimir('João');

imprimir(undefined, 'da Silva');

imprimir(null, 'da Silva');