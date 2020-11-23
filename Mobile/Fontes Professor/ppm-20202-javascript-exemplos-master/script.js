window.alert('Bem-vindo a calculadora em JavaScript!');

var opcao = parseInt(window
    .prompt('Calculadora! \n\nDigite a operação: \n1 - Soma \n2 - Subtração\n3 - Multiplicação\n4 - Divisão\n5 - Potência\nOpção: '));
var numero1 = parseFloat(window.prompt('Digite o primeiro número: '));
var numero2 =  parseFloat(window.prompt('Digite o segundo número: '));
var resultado;

switch(opcao) {
    case 1:
        resultado = numero1 + numero2;
        window.alert('Resultado: ' + resultado);
        break;
    default:
        window.alert('Opção inválida!');
}

