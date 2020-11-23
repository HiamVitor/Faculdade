
package Testes;

import Controller.daoCategoria;
import Controller.daoTitulo;
import Enums.Tipos;
import Model.Categoria;
import Model.Titulo;

public class testeCrudTitulo {
    public static void main(String[] args) {
        daoTitulo dao = new daoTitulo();
        //
        Titulo t1 = new Titulo(0, "turbo pascal 6 completo e total", 
                Tipos.LIV, "ensina pascal", new daoCategoria().retrieve(Categoria.class, 1));
        Titulo t2 = new Titulo(0, "20 mil leguas", 
                Tipos.LIV, "ficção", new daoCategoria().retrieve(Categoria.class, 2));
        Titulo t3 = new Titulo(0, "super interessante", 
                Tipos.REV, "era legal", new daoCategoria().retrieve(Categoria.class, 4));
        Titulo t4 = new Titulo(0, "zé colmeia e catatau", 
                Tipos.HQ, "comédia", new daoCategoria().retrieve(Categoria.class, 5));
        //
        System.out.println("Adicionados");
        //
        try{
            /*
            dao.add(t1);
            dao.add(t2);
            dao.add(t3);
            dao.add(t4);
            */
            for (Titulo titulo : dao.getList(new daoCategoria().retrieve(Categoria.class, 4))){
                System.out.println(titulo.getNome()+ "\t" + titulo.getCategoria());
            }
        }catch(Exception ex){
            System.out.println("ERRO:"+ex.getMessage());
        }
            
        
    }
    
}
