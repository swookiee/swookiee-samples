package com.swookiee.devcon.demo.groovy;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/2/fizzbuzz")
@Produces(APPLICATION_JSON)
public interface FizzBuzzGroovy {

    @GET
    @Path("{limit}")
    List<String> fizzbuzz(@PathParam("limit") Integer limit);
}
