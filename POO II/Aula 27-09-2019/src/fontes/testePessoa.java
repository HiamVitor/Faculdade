
package fontes;

import Classes.Pessoa;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

public class testePessoa {
    public static void main(String[] args) {
        LinkedList<Pessoa> lista = new LinkedList<>();
        DateTimeFormatter formato =
        DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        lista.add(new Pessoa("joao", LocalDate.now()));
        lista.add(new Pessoa("maria", LocalDate.of(2010, 5, 20)));
        lista.add(new Pessoa("joaquim", LocalDate.parse("01/02/1970", formato)));
 
        for (Pessoa pessoa : lista) {
            System.out.println(pessoa.getNome() + "\t" 
                             + pessoa.getNascimento().format(formato));
        }
        
    }
    
}
