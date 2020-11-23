var botaoCalcular = document.getElementById('calcular');
var botaoLimpar = document.getElementById('limpar');
var inputAnoNascimento = document.getElementById('anoNascimento');
var paragrafoResultado = document.getElementById('resultado');

botaoCalcular.addEventListener('click', function() {
    var ano = parseInt(inputAnoNascimento.value);
    var anoAtual = new Date().getFullYear();
    
    if(isNaN(ano)) {
        alert('Ano de nascimento inválido!');
        inputAnoNascimento.value = '';
    } else if(ano > anoAtual) {
        alert('Ano de nascimento maior que o ano atual!');
        inputAnoNascimento.value = '';
    } else {
        var resultado = anoAtual - ano;
        paragrafoResultado.innerText = "Idade: " + resultado + " ano(s).";
    }
});

botaoLimpar.onclick = function() {
    inputAnoNascimento.value = '';
    paragrafoResultado.innerText = '';
};

