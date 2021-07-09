package br.com.concessionaria.api.acessorios;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("acessorio")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Stateless
public class AcessoriosResource {

    @PersistenceContext(unitName = "ConsessionariaPU")
    private EntityManager entityManager;

    @GET
    @Path("{id}")
    public Acessorio getAcessorios(@PathParam("id") Long id) {
        return entityManager.find(Acessorio.class, id);
    }

    @POST
    public Acessorio addAcessorios(Acessorio acessorios) {
        entityManager.persist(acessorios);
        return acessorios;
    }

    @PUT
    @Path("{id}")
    public Acessorio updateAcessorios(@PathParam("id") Long id, Acessorio acessorios) {
        acessorios.setId(id);
        entityManager.merge(acessorios);
        return acessorios;
    }

    @DELETE
    @Path("{id}")
    public void removeAcessorios(@PathParam("id") Long id) {
        entityManager.remove(getAcessorios(id));
    }

    @GET
    public List<Acessorio> getAcessorioss() {
        return entityManager.createQuery("SELECT l FROM Acessorio l", Acessorio.class).getResultList();
    }
}
