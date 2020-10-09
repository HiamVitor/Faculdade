var campoNome = document.getElementById("campoNome");
var msgPronta = document.getElementById("paragrafo");

var botaoOK = document.getElementById("botaoOk");
botaoOK.onclick = helloWorld;

var botaoLimpar = document.getElementById("botaoLimpar");
botaoLimpar.addEventListener("click", limpar);

function helloWorld() {
    var nome = campoNome.value.trim();

    var mensagem = "Hello world, " + nome + "!";

    msgPronta.innerHTML = mensagem;
}

function limpar() {
    campoNome.value = "";
    msgPronta.innerHTML = "";
}
