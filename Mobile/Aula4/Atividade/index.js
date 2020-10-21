var trocaBandeira = document.getElementById('ListaEstados');

trocaBandeira.addEventListener('click', function () {
    
    var estado = parseFloat(document.getElementById('estados').value);

    document.getElementById('indice').innerText = estado;

    var bandeira;

    if (estado = "AC") {
        Estado = "Acre"
        bandeira = "./img/Acre.png"
    }else if (estado = "AP") {
        Estado = "Amapá"
        bandeira = "./img/Amapá.png"
    }
    else if (estado = "AM") {
        Estado = "Amazonas"
        bandeira = "./img/Amazonas.png"
    }
    else if (estado = "BA") {
        Estado = "Bahia"
        bandeira = "./img/Bahia.png"
    }
    else if (estado = "CE") {
        Estado = "Ceará"
        bandeira = "./img/Ceará.png"
    }
    else if (estado = "DF") {
        Estado = "Distrito Federal"
        bandeira = "./img/Distrito_Federal.png"
    }
    else if (estado = "ES") {
        Estado = "Espírito Santo"
        bandeira = "./img/Espírito_Santo.png"
    }
    else if (estado = "GO") {
        Estado = "Goiás"
        bandeira = "./img/Goiás.png"
    }
    else if (estado = "MA") {
        Estado = "Maranhão"
        bandeira = "./img/Maranhão.png"
    }
    else if (estado = "MT") {
        Estado = "Mato Grosso"
        bandeira = "./img/Mato_Grosso.png"
    }
    else if (estado = "MS") {
        Estado = "Mato Grosso do Sul"
        bandeira = "./img/Mato_Grosso_do_Sul.png"
    }
    else if (estado = "MG") {
        Estado = "Minas Gerais"
        bandeira = "./img/Minas_Gerais.png"
    }
    else if (estado = "PA") {
        Estado = "Pará"
        bandeira = "./img/Pará.png"
    }
    else if (estado = "PB") {
        Estado = "Paraíba"
        bandeira = "./img/Paraíba.png"
    }
    else if (estado = "PR") {
        Estado = "Paraná"
        bandeira = "./img/Paraná.png"
    }
    else if (estado = "PE") {
        Estado = "Pernambuco"
        bandeira = "./img/Pernambuco.png"
    }
    else if (estado = "PI") {
        Estado = "Piauí"
        bandeira = "./img/Piauí.png"
    }
    else if (estado = "RJ") {
        Estado = "Rio de Janeiro"
        bandeira = "./img/Rio_de_Janeiro.png"
    }
    else if (estado = "RN") {
        Estado = "Rio Grande do Norte"
        bandeira = "./img/Rio_Grande_do_Norte.png"
    }
    else if (estado = "RS") {
        Estado = "Rio Grande do Sul"
        bandeira = "./img/Rio_Grande_do_Sul.png"
    }
    else if (estado = "RO") {
        Estado = "Rondônia"
        bandeira = "./img/Rondônia.png"
    }
    else if (estado = "RR") {
        Estado = "Roraima"
        bandeira = "./img/Roraima.png"
    }
    else if (estado = "SC") {
        Estado = "Santa Catarina"
        bandeira = "./img/Santa_Catarina.png"
    }
    else if (estado = "SP") {
        Estado = "São Paulo"
        bandeira = "./img/São_Paulo.png"
    }
    else if (estado = "SE") {
        Estado = "Sergipe"
        bandeira = "./img/Sergipe.png"
    }
    else if (estado = "TO") {
        Estado = "./"
        bandeira = "./img/Tocantins.png"
    }

    var EstadosMostra = (document.getElementById('EstadosMostra').innerHTML = bandeira);
    EstadosMostra.innerText = 'Estados:' + bandeira;
    EstadosMostra.classList.value = classe;
});
