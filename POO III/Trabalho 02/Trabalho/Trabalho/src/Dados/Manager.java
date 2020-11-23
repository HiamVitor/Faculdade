
package Dados;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

abstract public class Manager {
    private static EntityManager entity = null;
    //
    public static EntityManager getEntityManager(){
        if (entity == null){
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("TrabalhoJPA");
            entity = factory.createEntityManager();
        }        
        return entity;
    }
}
