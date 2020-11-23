
var campoNome = document.getElementById('campoNome');
var mensagemHelloWorld = document.getElementById('mensagemHelloWorld');
var botaoOk = document.getElementById('botaoOk');
botaoOk.onclick = helloWorld;
var botaoLimpar = document.getElementById('botaoLimpar');
botaoLimpar.addEventListener('click', limpar);

function helloWorld() {
    var nome = campoNome.value.trim();
    var mensagem = 'Hello world, ' + nome + '!';
    mensagemHelloWorld.innerText = mensagem;
}
function limpar() {
    campoNome.value = '';
    mensagemHelloWorld.innerText = '';
}