
package Controller;

import Dados.Manager;
import java.util.List;
import javax.persistence.Query;

public abstract class dao<T> {
    public void add(T objeto){
        Manager.getEntityManager().getTransaction().begin();
        Manager.getEntityManager().persist(objeto);
        Manager.getEntityManager().getTransaction().commit();
    }
    public void update(T objeto){
        Manager.getEntityManager().getTransaction().begin();
        Manager.getEntityManager().merge(objeto);
        Manager.getEntityManager().getTransaction().commit();
    }
    public void delete(T objeto){
        Manager.getEntityManager().getTransaction().begin();
        Manager.getEntityManager().remove(objeto);
        Manager.getEntityManager().getTransaction().commit();
    }
    public T retrieve(Class<T> classType,int id){
        return (Manager.getEntityManager().find(classType, id));
    }   
    public List<T> getList(String JPQL){
        Query query = Manager.getEntityManager().createQuery(JPQL);
        return query.getResultList();
    }
    public List<T> getList(String JPQL,String filtro){        
        Query query = Manager.getEntityManager().createQuery(JPQL);
        query.setParameter(1, "%"+filtro.toUpperCase()+"%");
        return query.getResultList();
    }    
    public List<T> getList(String JPQL,Object... args){        
        Query query = Manager.getEntityManager().createQuery(JPQL);
        for (int i=0; i < args.length; i++){
            query.setParameter((i+1), args[i]);
        }
        return query.getResultList();
    }    
}
