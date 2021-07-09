package br.com.concessionaria.api.carro;

import br.com.concessionaria.api.marca.Marca;
import java.util.ArrayList;
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

@Path("carros")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Stateless
public class CarroResource {

    @PersistenceContext(unitName = "ConsessionariaPU")
    private EntityManager entityManager;

    @GET
    @Path("{id}")
    public CarroDTO getCarro(@PathParam("id") Long id) {
        Carro carro = entityManager.find(Carro.class, id);
        
        List<Long> formaIds = new ArrayList<Long>();
        carro.getFormaPagto().forEach((forma) -> {
            formaIds.add(forma.getId());
        });

        List<Long> condIds = new ArrayList<Long>();
        carro.getCondPagto().forEach((cond) -> {
            formaIds.add(cond.getId());
        });

        List<Long> acessorioIds = new ArrayList<Long>();
        carro.getAcessorio().forEach((acessorio) -> {
            formaIds.add(acessorio.getId());
        });

        return new CarroDTO(carro.getId(), carro.getModelo(), carro.getImagem(),
                carro.getAno(), carro.getPreco(), carro.getMarca().getId(),
                formaIds, condIds, acessorioIds);
    }

    @POST
    public Carro addCarro(Carro carro) {
        entityManager.persist(carro);
        return carro;
    }

    @PUT
    @Path("{id}")
    public Carro updateCarro(@PathParam("id") Long id, Carro carro) {
        carro.setId(id);
        Marca marca = entityManager.find(Marca.class, carro.getMarca().getId());
        carro.setMarca(marca);
        entityManager.merge(carro);
        return carro;
    }

    @DELETE
    @Path("{id}")
    public void removeCarro(@PathParam("id") Long id) {
        entityManager.remove(entityManager.find(Carro.class, id));
    }

    @GET
    public List<CarroDTO> getCarros() {
        List<Carro> listaCarros = entityManager.createQuery("SELECT c FROM Carro c", Carro.class).getResultList();
        List<CarroDTO> listaCarroDTO = new ArrayList<>();

        listaCarros.forEach((carro) -> {
            
            List<Long> formaIds = new ArrayList<>();
            carro.getFormaPagto().forEach((forma) -> {
                formaIds.add(forma.getId());
            });

            List<Long> condIds = new ArrayList<>();
            carro.getCondPagto().forEach((cond) -> {
                condIds.add(cond.getId());
            });

            List<Long> acessorioIds = new ArrayList<>();
            carro.getAcessorio().forEach((acessorio) -> {
                acessorioIds.add(acessorio.getId());
            });

            listaCarroDTO.add(new CarroDTO(carro.getId(), carro.getModelo(), carro.getImagem(),
                    carro.getAno(), carro.getPreco(), carro.getMarca().getId(),
                    formaIds, condIds, acessorioIds));
        });
        return listaCarroDTO;
    }
}
