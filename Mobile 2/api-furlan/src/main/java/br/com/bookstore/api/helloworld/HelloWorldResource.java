package br.com.bookstore.api.helloworld;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author aula
 */
@Path("hello-world")
public class HelloWorldResource {
    
    @GET
    public String helloWorldMensagem() {
        return "Hello World Web Services em Java";
    }
}
