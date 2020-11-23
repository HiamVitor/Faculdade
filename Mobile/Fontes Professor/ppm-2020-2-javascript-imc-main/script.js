var calcularButton = document.getElementById('calcular');

calcularButton.addEventListener('click', function() {
    var altura = parseFloat(document.getElementById('altura').value);
    var peso = parseFloat(document.getElementById('peso').value);
    var imc = (peso / (altura * altura));
    
    document.getElementById('indice').innerText = 'ÍNDICE: ' + imc.toFixed(2);    

    var classficacao;
    var classe;

    if(imc < 16) {
        classficacao = 'Magreza grave';
        classe = 'magreza-grave';
    } else if(imc >= 16 && imc < 17) {
        classficacao = 'Magreza moderada';
        classe = 'magreza-moderada';
    } else if(imc >= 17 && imc < 18.5) {
        classficacao = 'Magreza leve';
        classe = 'magreza-leve';
    } else if(imc >= 18.5 && imc < 25) {
        classficacao = 'Saudável';
    }  else if(imc >= 25 && imc < 30) {
        classficacao = 'Sobrepeso';
        classe = 'sobrepeso';
    } else if(imc >= 30 && imc < 35) {
        classficacao = 'Obesidade Grau I';
        classe = "obesidade-grau-i";
    }  else if(imc >= 35 && imc < 40) {
        classficacao = 'Obesidade Grau II'  
        classe = "obesidade-grau-ii";
    }  else if(imc >= 40) {
        classficacao = 'Obesidade Grau III';
        classe = "obesidade-grau-iii";
    }

    var paragrafoClassificacao = document.getElementById('classificacao');
    paragrafoClassificacao.innerText = 'CLASSIFICAÇÃO: ' + classficacao;
    paragrafoClassificacao.classList.value = classe;
});