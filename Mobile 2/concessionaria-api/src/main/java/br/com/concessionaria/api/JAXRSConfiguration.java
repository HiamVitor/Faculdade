package br.com.concessionaria.api;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Application;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author aula
 */
@ApplicationPath("api")
public class JAXRSConfiguration extends Application {
    
}
