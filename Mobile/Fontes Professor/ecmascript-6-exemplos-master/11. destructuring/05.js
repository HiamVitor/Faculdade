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

let felipe = new Pessoa('Felipe', 'M', new Date(1996, 1, 20));

let { dataNascimento, nome } = felipe;
console.log(nome);
console.log(dataNascimento);

let { dataNascimento: d, nome: n} = felipe;
console.log(n);
console.log(d);