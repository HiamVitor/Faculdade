package br.com.concessionaria.api.marca;

import br.com.concessionaria.api.marca.Marca;
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

@Path("marcas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Stateless
public class MarcaResource {

    @PersistenceContext(unitName = "ConsessionariaPU")
    private EntityManager entityManager;

    @GET
    @Path("{id}")
    public Marca getMarca(@PathParam("id") Long id) {
        return entityManager.find(Marca.class, id);
    }

    @POST
    public Marca addMarca(Marca marca) {
        entityManager.persist(marca);
        return marca;
    }

    @PUT
    @Path("{id}")
    public Marca updateMarca(@PathParam("id") Long id, Marca marca) {
        marca.setId(id);
        entityManager.merge(marca);
        return marca;
    }

    @DELETE
    @Path("{id}")
    public void removeMarca(@PathParam("id") Long id) {
        entityManager.remove(getMarca(id));
    }

    @GET
    public List<Marca> getMarcas() {
        return entityManager.createQuery("SELECT m FROM Marca m", Marca.class).getResultList();
    }
}
