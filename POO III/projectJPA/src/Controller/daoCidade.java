package Controller;

import Dados.Manager;
import Model.Cidade;

public class daoCidade {
    public void add(Cidade cidade){
        Manager.getEntityManager().getTransaction().begin();
        Manager.getEntityManager().persist(cidade);
        Manager.getEntityManager().getTransaction().commit();
    }
    public void update(Cidade cidade){
        Manager.getEntityManager().getTransaction().begin();
        Manager.getEntityManager().merge(cidade);
        Manager.getEntityManager().getTransaction().commit();
    }
    public void delete(Cidade cidade){
        Manager.getEntityManager().getTransaction().begin();
        Manager.getEntityManager().remove(cidade);
        Manager.getEntityManager().getTransaction().commit();
    }
    
    public Cidade retriev(int id){
        return (Manager.getEntityManager().find(Cidade.class, id));
    }
}
