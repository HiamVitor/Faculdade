/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bookstore.api.livro;

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

/**
 *
 * @author aula
 */
@Path("livros")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Stateless
public class LivroResource {
    
    @PersistenceContext(unitName = "BookstorePU")
    private EntityManager entityManager; 
    
    @GET
    @Path("{id}")
    public Livro getLivro(@PathParam("id") Long id) {
        return entityManager.find(Livro.class, id);
    }
    
    @POST
    public Livro addLivro(Livro livro) {
        entityManager.persist(livro);
        return livro;
    }
    
    @PUT
    @Path("{id}")
    public Livro updateLivro(@PathParam("id") Long id, Livro livro) {
       livro.setId(id);
       entityManager.merge(livro);
       return livro;
    }
    
    @DELETE    
    @Path("{id}")
    public void removeLivro(@PathParam("id") Long id) {
        entityManager.remove(getLivro(id));
    }
    
    @GET
    public List<Livro> getLivros() {
       return entityManager.createQuery("SELECT l FROM Livro l", Livro.class).getResultList();
    }
}