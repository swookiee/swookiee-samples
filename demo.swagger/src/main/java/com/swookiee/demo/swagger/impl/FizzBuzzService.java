package com.swookiee.demo.swagger.impl;

import com.swookiee.demo.swagger.FizzBuzz;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import org.osgi.service.component.annotations.Component;

@Component
public class FizzBuzzService implements FizzBuzz {

    @Override
    public List<String> fizzbuzz(final Integer limit) {
        if (limit > 10000) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }

        List<String> result = new ArrayList<>();

        for (int k = 1; k <= limit; k++) {
            if (k % 15 == 0) {
                result.add("FizzBuzz");
            } else if (k % 3 == 0) {
                result.add("Fizz");
            } else if (k % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(Integer.toString(k));
            }
        }
        return result;
    }
}
