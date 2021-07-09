package br.com.concessionaria.api.condPagto;

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

@Path("condPagtos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Stateless
public class CondPagtoResource {

    @PersistenceContext(unitName = "ConsessionariaPU")
    private EntityManager entityManager;

    @GET
    @Path("{id}")
    public CondPagto getCondPagto(@PathParam("id") Long id) {
        return entityManager.find(CondPagto.class, id);
    }

    @POST
    public CondPagto addCondPagto(CondPagto formaPagto) {
        entityManager.persist(formaPagto);
        return formaPagto;
    }

    @PUT
    @Path("{id}")
    public CondPagto updateCondPagto(@PathParam("id") Long id, CondPagto formaPagto) {
        formaPagto.setId(id);
        entityManager.merge(formaPagto);
        return formaPagto;
    }

    @DELETE
    @Path("{id}")
    public void removeCondPagto(@PathParam("id") Long id) {
        entityManager.remove(getCondPagto(id));
    }

    @GET
    public List<CondPagto> getCondPagtos() {
        return entityManager.createQuery("SELECT l FROM CondPagto l", CondPagto.class).getResultList();
    }
}
