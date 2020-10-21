
function imprimir(...parametros) {
     for (const p of parametros) {
        console.log(p);     
    }
}

imprimir(1, 'a', 'teste', new Date(), [1,2,3,4,5], true);

