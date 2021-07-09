package br.com.bookstore.api.autor;

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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import static javax.ws.rs.core.Response.Status;

/**
 *
 * @author aula
 */
@Path("autores")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Stateless
public class AutorResource {

    @PersistenceContext(unitName = "BookstorePU")
    private EntityManager entityManager;
    
    public AutorResource() {}

    @GET
    public List<Autor> getAutores(@QueryParam("nome") String nome) {
        if(nome != null) {
           return entityManager
//                   .createNativeQuery("SELECT * FROM autores WHERE nome=:nome") - SQL
                   .createQuery("SELECT a FROM Autor a WHERE LOWER(a.nome) LIKE :nome", Autor.class) // JPQL
                   .setParameter("nome", "%" + nome.toLowerCase() + "%")
                   .getResultList();
        }
//        return entityManager
//                .createNativeQuery("SELECT * FROM autores", Autor.class)
//                .getResultList(); - SQL
        return entityManager
                .createQuery("SELECT a FROM Autor a", Autor.class) // JPQL
                .getResultList();
    }

    @GET
    @Path("{id}")
    public Response getAutor(@PathParam("id") int id) {
        Autor autor = findAutor(id);        
        if (autor == null) {
            return autorNotFoundResponse();
        }
        return Response.ok(autor).build();
    }

    @POST
    public Response addAutor(Autor autor) {
        entityManager.persist(autor);
        return Response.status(Status.CREATED).entity(autor).build();
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") int id) {
        Autor autor = findAutor(id);
        if(autor == null) {
            return autorNotFoundResponse();
        } 
        entityManager.remove(autor);
//        return Response.status(Status.NO_CONTENT).build();
        return Response.noContent().build();
    }
    
    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") int id, Autor autorAtualizado) {
        Autor autor = findAutor(id);
        if(autor == null) {
            return autorNotFoundResponse();
        }
        autorAtualizado.setId(id);
        entityManager.merge(autorAtualizado);
        return Response.ok(autor).build();
    }
    
    public Autor findAutor(int id) {
        return entityManager.find(Autor.class, id);
    }
    
    public Response autorNotFoundResponse() {      
//            throw new NotFoundException("Autor não encontrado");
//            throw new  WebApplicationException("Autor não encontrado", Status.NOT_FOUND);;
        return Response
                    .status(Status.NOT_FOUND)
                    .entity("Autor não encontrado para exclusão")
                    .build();
    }
}
