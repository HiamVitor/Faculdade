
package teste.Classes;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class testePessoa {
    public static void main(String[] args) {
        LinkedList<Pessoa> lista = new LinkedList();
        lista.add(new Pessoa("joao", 20, "sem"));
        lista.add(new Pessoa("maria", 25, "analista"));
        lista.add(new Pessoa("celso", 30, "designer"));
        lista.add(new Pessoa("antonia", 30, "gerente"));
        lista.add(new Pessoa("lucia", 40, "analista"));
        lista.add(new Pessoa("pedro", 20, "programador"));
        //
        for(Pessoa pessoa : lista){
            System.out.println(pessoa.getNome()+"\t"+pessoa.getIdade()+
                    "\t"+pessoa.getProfissao());
        }
        //
        for(int i=0; i < lista.size(); i++){
            System.out.println(lista.get(i).getNome());
        }
        System.out.println("--------------");
        lista.forEach(pessoa -> System.out.println(pessoa.getNome()));
        //
        System.out.println("--------------------");
        Collections.sort(lista, 
        (Pessoa p1, Pessoa p2) -> 
        p1.getNome().compareTo(p2.getNome()));
        //
        lista.forEach(pessoa -> System.out.println(pessoa.getNome()));
        //filtrar maiores de 30
        List<Pessoa> retorno = lista.stream().filter(
        p -> p.getIdade()>=30
        ).collect(Collectors.toList());
        //filtrar nomes com letra f
        List<Pessoa> retornoF = lista.stream().filter(
        p -> p.getNome().startsWith("F")
        ).collect(Collectors.toList());
        //
        System.out.println("---Maiores de 30 anos---");
        retorno.forEach(
        p -> System.out.println(p.getNome()+"-"+p.getIdade()));        
    }    
}
