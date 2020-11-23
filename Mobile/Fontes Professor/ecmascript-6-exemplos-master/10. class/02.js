class Pessoa {

    constructor(nome, sexo = 'F', dataNascimento = new Date()) {
        this.nome = nome;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
    }

    getInformacoes() {
        return `Nome: ${this.nome} \nSexo: ${this.sexo}\nData de nascimento: ${this.dataNascimento}`
    }

    getIdadeAtual() {
        return new Date().getFullYear() - this.dataNascimento.getFullYear();
    }

    static imprimirIdade(p) {
        console.log(p.getIdade());
    }
}

let p = new Pessoa('A', 'F', new Date(1991, 1, 15));
console.log(p);

let joao = new Pessoa('João');
console.log(joao);

let julio = new Pessoa('Julio', 'M');
console.log(julio);

console.log(p.getInformacoes());
console.log(p instanceof Pessoa);
console.log(typeof Pessoa);
console.log(typeof p);
console.log(p.constructor.name);

// console.log(p.getIdadeAtual());
// Pessoa.imprimirIdade(p);


