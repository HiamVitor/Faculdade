package br.com.bookstore.api.HelloWolrd;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("hello-word")
public class HelloWorldResource {

    @GET
    public String helloWorld() {
        return "Hello World Web Services em java!";
    }

}
