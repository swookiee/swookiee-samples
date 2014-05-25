package com.swookiee.demo.swagger;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import java.util.List;
import javax.ws.rs.*;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Api("FizzBuzz!!")
@Path("/4/fizzbuzz")
public interface FizzBuzz {

    @GET
    @Produces(APPLICATION_JSON)
    @Path("/{limit}")
    @ApiOperation(value = "FizzBuzz Calculus", response = String.class, responseContainer = "List")
    @ApiResponses(value = {
        @ApiResponse(code = 400, message = "If the limit input is greater than 10000")})
    List<String> fizzbuzz(@PathParam("limit") Integer limit);
}
