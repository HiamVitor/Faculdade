function subtracao(n1, n2) {
    // if(n1 !== undefined && n1 !== null) 
    if(!n1) {
        throw new Error('n1 não foi declarado');
    }
    if(typeof n1 !== 'number') {
        throw new Error('n1 não é um número');
    }
    if(!n2) {
        throw new Error('n2 não foi declarado');
    }
    if(typeof n2 !== 'number') {
        throw new Error('n2 não é um número');
    }
    return n1 - n2;     
}

console.log(subtracao(1, new Date()));