var botaoAdicionar = document.getElementById('adicionar');
var inputTarefa = document.getElementById('tarefa');

inputTarefa.onkeypress = function(evento) {
    if(evento.key === 'Enter') {
        adicionar();
    }
};

botaoAdicionar.addEventListener('click', adicionar);

function adicionar() {
    var tarefa = inputTarefa.value;
    if(tarefa !== '') {
        var li = document.createElement('li');      
        var span = document.createElement('span');
        span.innerText = tarefa;
        
        li.classList.add('para-fazer');
        
        span.onclick = function() {
            li.classList.remove('para-fazer');
            li.classList.add('concluida');
        };
        span.ondblclick = function() {
            li.classList.remove('concluida');
            li.classList.add('para-fazer');
        };

        var button = document.createElement('button');
        button.innerText = 'Excluir';  
        button.classList.add('btn-excluir');
        button.onclick = function() {
            ol.removeChild(li);
        };

        // var textoExcluir = document.createTextNode('Excluir');
        // excluir.appendChild(textoExcluir);       
        li.appendChild(span);
        li.appendChild(button);

        var ol = document.getElementById('tarefas');
        ol.appendChild(li);

        inputTarefa.value = '';
    }
}