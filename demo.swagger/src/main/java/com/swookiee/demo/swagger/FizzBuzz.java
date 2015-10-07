package com.swookiee.demo.swagger;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import javax.ws.rs.*;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Api("FizzBuzz")
@Path("/3/fizzbuzz")
public interface FizzBuzz {

    @GET
    @Produces(APPLICATION_JSON)
    @Path("/{limit}")
    @ApiOperation(value = "FizzBuzz Calculus", responseContainer = "List", response = String.class)
    @ApiResponses(value = {
        @ApiResponse(code = 400, message = "If the limit input is greater than 10000")})
    List<String> fizzbuzz(@PathParam("limit") Integer limit);
}
