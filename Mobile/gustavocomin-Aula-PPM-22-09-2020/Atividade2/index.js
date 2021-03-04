var campoPeso = document.getElementById('campoPeso');
var campoAltura = document.getElementById('campoAltura');
var teste = document.getElementsByClassName('teste').style.display;

var resultado = document.getElementById('resultado');
var tabela = document.getElementById('tabela');

var botaoCalcular = document.getElementById('botaoCalcular');

botaoCalcular.onclick = calcular;

var botaoLimpar = document.getElementById('botaoLimpar');

botaoLimpar.addEventListener('click', limpar);

function calcular() {
    var peso = parseFloat(campoPeso.value);
    var altura = parseFloat(campoAltura.value);

    if (isNaN(peso) && isNaN(altura)) {
        var calc = peso / (altura * altura);

        var mensagem = 'Seu IMC é: ' + calc + '!';


        resultado.innerHTML = mensagem;
    }

    if (teste == 'none') document.getElementsByClassName('teste').style.display = 'block';
    else document.getElementsByClassName('teste').style.display = 'none';
}

function limpar() {
    campoPeso.value = '';
    campoAltura.value = '';
    // resultado.innerHTML = "";
}
