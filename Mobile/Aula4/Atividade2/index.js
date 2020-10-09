var calcularbotao = document.getElementById('calcular');

calcularbotao.addEventListener('click', function () {
    var altura = parseFloat(document.getElementById('altura').value);
    var peso = parseFloat(document.getElementById('peso').value);
    var imc = peso / (altura * altura);

    document.getElementById('indice').innerText = imc.toFixed(2);

    var classificacao;

    if (imc < 16) {
        classe = 'magreza-grave';
        classificacao = 'Magreza grave';
    } else if (imc >= 16 && imc < 17) {
        classe = 'magreza-moderada';
        classificacao = 'Magreza moderada';
    } else if (imc >= 17 && imc < 18.5) {
        classe = 'magreza-leve';
        classificacao = 'Margreza leve';
    } else if (imc >= 18.5 && imc < 25) {
        classe = 'saudavel';
        classificacao = 'Saudável';
    } else if (imc >= 25 && imc < 30) {
        classe = 'sobrepeso';
        classificacao = 'Sobrepeso';
    } else if (imc >= 30 && imc < 35) {
        classe = 'obesidade-grau-i';
        classificacao = 'Obesidade grau I';
    } else if (imc >= 35 && imc < 40) {
        classe = 'obesidade-grau-ii';
        classificacao = 'Obesidade grau II';
    } else if (imc >= 40) {
        classe = 'obesidade-grau-iii';
        classificacao = 'Obesidade grau III';
    }

    var paragrafoClassifcacao = (document.getElementById('classificacao').innerText = classificacao);
    paragrafoClassifcacao.innerText = 'CLASSIFICAÇÃO:' + classificacao;
    paragrafoClassifcacao.classList.value = classe;
});
