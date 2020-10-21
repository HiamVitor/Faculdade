var calcularbotao = document.getElementById('calcular');

calcularbotao.addEventListener('click', function () {

    var classificacao;

    if ((planeta = 'Mercurio')) {
        gravidade = '0,37';
    } else if ((planeta = 'Venus')) {
        gravidade = '0,88';
    } else if ((planeta = 'Marte')) {
        gravidade = '0,38';
    } else if ((planeta = 'Jupiter')) {
        gravidade = '2,64';
    } else if ((planeta = 'Saturno')) {
        gravidade = '1,15';
    } else if ((planeta = 'Urano')) {
        gravidade = '1,17';
    }

    var peso = parseFloat(document.getElementById('peso').value);
    var Peso = (peso / 10) * gravidade;

    document.getElementById('indice').innerText = Peso.toFixed(2);


    var paragrafoClassifcacao = (document.getElementById('PlanetasMostra').innerText = Peso);
    paragrafoClassifcacao.innerText = 'Peso::' + Peso;
});
