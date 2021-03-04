var botaoAdicionar = document.getElementById('adicionar');
var inputTarefa = document.getElementById('tarefa');

inputTarefa.onkeypress = function (event) {
    if (event.key === 'Enter') {
        adicionar();
    }
};

botaoAdicionar.addEventListener('click', adicionar);

function adicionar() {
    var tarefa = inputTarefa.value;
    if (tarefa !== '') {
        var li = document.createElement('li');

        var span = document.createElement('span');
        span.innerHTML = tarefa;

        li.classList.add('paraFazer');

        span.onclick = function () {
            li.classList.remove('paraFazer');
            li.classList.add('concluida');
        };

        span.ondblclick = function () {
            li.classList.remove('concluida');
            li.classList.add('paraFazer');
        };

        var botaoExcluir = document.createElement('button');
        botaoExcluir.innerText = 'Excluir';
        botaoExcluir.classList.add('btn-excluir');
        botaoExcluir.onclick = function () {
            ol.removeChild(li);
        };
        
        li.appendChild(span);
        li.appendChild(botaoExcluir);

        var ol = document.getElementById('tarefas');
        ol.appendChild(li);

        inputTarefa.value = '';
    }
}
