
package Testes;

import Controller.daoCidade;
import Enums.Estados;
import Model.Cidade;

public class testeCrudCidade {
    public static void main(String[] args) {
        daoCidade dao = new daoCidade();                
        
        Cidade c = new Cidade(0, "tubarao", Estados.SC);
        try{
            dao.add(c);
        }catch(Exception ex){
            System.out.println("ERRO:"+ex.getMessage());
        }
        
    }
    
}
