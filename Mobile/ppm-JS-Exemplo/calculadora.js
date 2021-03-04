var opcao = parseInt(window.prompt(
  'Calculadora! \n Digite a Operação: \n 1 - Soma \n 2 - Subtração \n 3 - Multiplicação \n 4 - Divisão \n 5 - Potência \n Opção:'
));

var numero1 = parseFloat(window.prompt('Digite o primeiro número: '));
var numero2 = parseFloat(window.prompt('Digite o segundo  número: '));
var resultado;

switch (opcao) {
  case 1:
    resultado = numero1 + numero2;
    window.alert('Resultado: ' + resultado);
    window.alert('Resultado: ' + resultado);
    break;
  case 2:
    resultado = numero1 - numero2;
    window.alert('Resultado: ' + resultado);
    break;
  case 3:
    resultado = numero1 * numero2;
    window.alert('Resultado: ' + resultado);
    break;
  case 4:
    resultado = numero1 / numero2;
    window.alert('Resultado: ' + resultado);
    break;
  case 5:
    resultado = Math.pow(numero1,numero2);
    window.alert('Resultado: ' + resultado);
    break; 
  default:
    window.alert('Opção inválida!');
}
