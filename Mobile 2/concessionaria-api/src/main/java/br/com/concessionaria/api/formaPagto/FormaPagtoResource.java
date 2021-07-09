package br.com.concessionaria.api.formaPagto;

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

@Path("formasPagto")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Stateless
public class FormaPagtoResource {

    @PersistenceContext(unitName = "ConsessionariaPU")
    private EntityManager entityManager;

    @GET
    @Path("{id}")
    public FormaPagto getFormaPagto(@PathParam("id") Long id) {
        return entityManager.find(FormaPagto.class, id);
    }

    @POST
    public FormaPagto addFormaPagto(FormaPagto formaPagto) {
        entityManager.persist(formaPagto);
        return formaPagto;
    }

    @PUT
    @Path("{id}")
    public FormaPagto updateFormaPagto(@PathParam("id") Long id, FormaPagto formaPagto) {
        formaPagto.setId(id);
        entityManager.merge(formaPagto);
        return formaPagto;
    }

    @DELETE
    @Path("{id}")
    public void removeFormaPagto(@PathParam("id") Long id) {
        entityManager.remove(getFormaPagto(id));
    }

    @GET
    public List<FormaPagto> getFormaPagtos() {
        return entityManager.createQuery("SELECT l FROM FormaPagto l", FormaPagto.class).getResultList();
    }
}
