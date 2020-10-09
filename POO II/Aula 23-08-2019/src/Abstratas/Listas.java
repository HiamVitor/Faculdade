
package Abstratas;

import Classes.Cidade;
import Classes.Fornecedor;
import Classes.Produto;
import java.util.LinkedList;

abstract public class Listas {
    private static LinkedList<Cidade> cidadeList = 
            new LinkedList<>();
    private static LinkedList<Fornecedor> fornecedorList = 
            new LinkedList<>();
    private static LinkedList<Produto> produtoList = 
            new LinkedList<>();

    public static LinkedList<Cidade> getCidadeList() {
        return cidadeList;
    }

    public static LinkedList<Fornecedor> getFornecedorList() {
        return fornecedorList;
    }

    public static LinkedList<Produto> getProdutoList() {
        return produtoList;
    }
}
