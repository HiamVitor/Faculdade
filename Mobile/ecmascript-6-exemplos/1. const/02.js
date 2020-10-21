const pi = 3;

function area(r) {
    const pi = 3.14; // Escopos diferentes
    // pi = 3.14;
    console.log(pi);
    return pi * r * r;    
}
console.log(pi);    
console.log("A área é: " + area(2));

