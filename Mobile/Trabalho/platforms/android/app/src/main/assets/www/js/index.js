document.addEventListener('deviceready', onDeviceReady, false);

function onDeviceReady() {

    console.log('Running cordova-' + cordova.platformId + '@' + cordova.version);
    document.getElementById('deviceready').classList.add('ready');
}

var selectedRow = null;

function onFormSubmit(){
    var formData = read();
    if(selectedRow ==null){
        newDados(formData);
    }else{
        Update(formData);
    }    
    Limpar();
}
function read(){
    var formData = {};
    formData["nome"] = document.getElementById("nome").value;
    formData["idade"] = document.getElementById("idade").value;
    formData["cpf"] = document.getElementById("cpf").value;
    formData["endereco"] = document.getElementById("endereco").value;
    formData["telefone"] = document.getElementById("telefone").value;
    return formData;
}

function newDados(data){
    var table = document.getElementById("listaCadastro").getElementsByTagName('tbody')[0];
    // var botoes = document.getElementById("botao").getElementsByTagName('botoes')[0];
    var newRow = table.insertRow(table.length);
    nome = newRow.insertCell(0);
    nome.innerHTML = data.nome;
    idade = newRow.insertCell(1);
    idade.innerHTML = data.idade;
    cpf = newRow.insertCell(2);
    cpf.innerHTML = data.cpf;
    endereco = newRow.insertCell(3);
    endereco.innerHTML = data.endereco;
    telefone = newRow.insertCell(4);
    telefone.innerHTML = data.telefone;
    botoes = newRow.insertCell(5);
    botoes.innerHTML = `<a onClick="Editar(this)">Editar</a>
                       <a onClick="Excluir(this)">Deletar</a>`;

}

function Editar(td) {
    selectedRow = td.parentElement.parentElement;
    document.getElementById("nome").value = selectedRow.cells[0].innerHTML;
    document.getElementById("idade").value = selectedRow.cells[1].innerHTML;
    document.getElementById("cpf").value = selectedRow.cells[2].innerHTML;
    document.getElementById("endereco").value = selectedRow.cells[3].innerHTML;
    document.getElementById("telefone").value = selectedRow.cells[4].innerHTML;
}

function Limpar() {
    document.getElementById("nome").value = "";
    document.getElementById("idade").value = "";
    document.getElementById("cpf").value = "";
    document.getElementById("endereco").value = "";
    document.getElementById("telefone").value = "";
    selectedRow = null;
}

function Update(formData){
    selectedRow.cells[0].innerHTML = formData.nome;
    selectedRow.cells[1].innerHTML = formData.idade;
    selectedRow.cells[2].innerHTML = formData.cpf;
    selectedRow.cells[3].innerHTML = formData.endereco;
    selectedRow.cells[4].innerHTML = formData.telefone;
}

function Excluir(td){
    row = td.parentElement.parentElement;
    document.getElementById("listaCadastro").deleteRow(row.rowIndex);
    Limpar();
}