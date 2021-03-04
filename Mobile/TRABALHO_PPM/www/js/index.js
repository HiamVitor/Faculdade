idade = '';
cpf = '';
endereco = '';
telefone = '';

document.addEventListener('deviceready', onDeviceReady, false);

function onDeviceReady() {
    // Cordova is now initialized. Have fun!

    console.log('Running cordova-' + cordova.platformId + '@' + cordova.version);
    document.getElementById('deviceready').classList.add('ready');
}

var selectedRow = null;

function onFormSubmit() {
    if (validate()) {
        var formData = read();
        if (selectedRow == null) {
            newDados(formData);
        } else {
            Update(formData);
        }
        Limpar();
    }
}

function read() {
    var formData = {};
    formData['nome'] = document.getElementById('nome').value;
    formData['idade'] = document.getElementById('idade').value;
    formData['cpf'] = document.getElementById('cpf').value;
    formData['endereco'] = document.getElementById('endereco').value;
    formData['telefone'] = document.getElementById('telefone').value;
    return formData;
}

function newDados(data) {
    var table = document.getElementById('listaCadastro').getElementsByTagName('tbody')[0];
    var newRow = table.insertRow(table.length);
    nome = newRow.insertCell(0);
    nome.innerHTML = data.nome;
    idade = data.idade;
    cpf = data.cpf;
    endereco = data.endereco;
    telefone = data.telefone;
    botoes = newRow.insertCell(1);
    botoes.innerHTML = `<a onClick="Editar(this)">Editar</a>
                       <a onClick="Excluir(this)">Deletar</a>`;
}

function Editar(td) {
    selectedRow = td.parentElement.parentElement;
    document.getElementById('nome').value = selectedRow.cells[0].innerHTML;
    document.getElementById('idade').value = idade;
    document.getElementById('cpf').value = cpf;
    document.getElementById('endereco').value = endereco;
    document.getElementById('telefone').value = telefone;
}

function Limpar() {
    document.getElementById('nome').value = '';
    document.getElementById('idade').value = '';
    document.getElementById('cpf').value = '';
    document.getElementById('endereco').value = '';
    document.getElementById('telefone').value = '';
    selectedRow = null;
}

function Update(formData) {
    selectedRow.cells[0].innerHTML = formData.nome;
    selectedRow.cells[1].innerHTML = formData.idade;
    selectedRow.cells[2].innerHTML = formData.cpf;
    selectedRow.cells[3].innerHTML = formData.endereco;
    selectedRow.cells[4].innerHTML = formData.telefone;
}

function Excluir(td) {
    row = td.parentElement.parentElement;
    document.getElementById('listaCadastro').deleteRow(row.rowIndex);
    Limpar();
}

function validate() {
    isValid = true;
    if (document.getElementById('nome').value == '') {
        isValid = false;
        document.getElementById('fullNameValidationError').classList.remove('hide');
    } else {
        isValid = true;
        if (!document.getElementById('fullNameValidationError').classList.contains('hide'))
            document.getElementById('fullNameValidationError').classList.add('hide');
    }
    return isValid;
}
