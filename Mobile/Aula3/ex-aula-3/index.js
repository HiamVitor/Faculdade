var campoIdade = document.getElementById("campoIdade");
var msgPronta = document.getElementById("paragrafo");

var botaoCalcular = document.getElementById("botaoCalcular");
botaoCalcular.onclick = calcular;

var botaoLimpar = document.getElementById("botaoLimpar");
botaoLimpar.addEventListener("click", limpar);

function calcular() {
    var idade = campoIdade.value;

    var calc = (new Date().getFullYear() - new Date(idade).getFullYear() - 1);

    var mensagem = "Sua idade é: " + calc + "!";

    msgPronta.innerHTML = mensagem;
}

function limpar() {
    campoIdade.value = "";
    msgPronta.innerHTML = "";
}
