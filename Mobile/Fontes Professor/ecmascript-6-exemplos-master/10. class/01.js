
function Pessoa(nome, sexo, dataNascimento) {
    // Atributos
    this.nome = nome;
    this.sexo = sexo;
    this.dataNascimento = dataNascimento;

    // Método
    this.getInformacoes = function() {
        return "Nome: " + nome + "\nSexo: " + sexo + "\nData de Nascimento: " + dataNascimento.toString();
    };
}

// Método
Pessoa.prototype.getIdadeAtual = function() {
    return new Date().getFullYear() - this.dataNascimento.getFullYear();
};

// Método estático
Pessoa.imprimirIdade = function(p) {
    console.log(p.getIdadeAtual());
};


// Pessoa p = new Pessoa("Nome", 'F', new Date(1991, 1, 15)) - em Java
var p = new Pessoa("A", "F", new Date(1991,1,15));
console.log(p);
console.log(p.getInformacoes());
console.log(p instanceof Pessoa);
console.log(typeof Pessoa);
console.log(typeof p);
console.log(p.constructor.name);

// console.log(p.getIdade());
Pessoa.imprimirIdade(p);
