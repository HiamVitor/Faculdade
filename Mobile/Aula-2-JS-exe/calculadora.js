window,alert('Bem-vindo a calculadora JavaScript');
var continuar;

do {
    var opcao = parseInt(
        window.prompt(
            "Calculadora! \n Digite a Operação: \n 1 - Soma \n 2 - Subtração \n" +
                "3 - Multiplicação \n 4 - Divisão \n 5 - Potência \n 0 - Sair \n Opção:"
        )
    );

    if (opcao === 0) {
        continuar = false;
    } else if (opcao >= 0 && opcao <= 5) {

        var numero1 = parseFloat(window.prompt("Digite o primeiro número: "));
        var numero2 = parseFloat(window.prompt("Digite o segundo  número: "));

        var resultado;

        switch (opcao) {
            case 1:
                resultado = numero1 + numero2;
                break;
            case 2:
                resultado = numero1 - numero2;
                break;
            case 3:
                resultado = numero1 * numero2;
                break;
            case 4:
                resultado = numero1 / numero2;
                break;
            case 5:
                resultado = Math.pow(numero1, numero2);
                break;
        }

        if (resultado !== undefined) {
            alert("Resultado: " + resultado);
        }

        continuar = confirm("Deseja continuar?");
    } else {
        alert("Opção inválida!");
        continuar =  true;
    }
} while (continuar);
alert('Saindoda calculadora...')