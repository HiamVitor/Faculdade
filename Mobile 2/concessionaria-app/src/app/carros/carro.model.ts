export interface CarroBase {
    id?: number;
    modelo: string;
    ano: number;
    preco: number;
    imagem: string;
    marca: number;
    placa: string;
}

export interface CarroViewModel extends CarroBase {
    formas: number[];
    acessorios: number[];
    condicoes: number[];
}
