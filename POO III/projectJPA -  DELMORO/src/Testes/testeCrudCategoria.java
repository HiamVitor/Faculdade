
package Testes;

import Controller.daoCategoria;
import Model.Categoria;

public class testeCrudCategoria {
    public static void main(String[] args) {
        daoCategoria dao = new daoCategoria();
        
        Categoria c1 = new Categoria(0, "categoria a", 10);
        Categoria c2 = new Categoria(0, "categoria a", 10);
        Categoria c3 = new Categoria(3, "categoria a", 10);
        Categoria c4 = new Categoria(0, "categoria a", 10);
        
        try{
            /*
            dao.add(c1);
            dao.add(c2);
            dao.add(c3);
            dao.add(c4);
            */
            for (Categoria c : dao.getList()){
                System.out.println(c.getId()+"\t"+c.getNome()+"\t"+c.getValor());
            }
        }catch(Exception ex){
            System.out.println("ERRO: "+ex.getMessage());
        }
    }
    
}
