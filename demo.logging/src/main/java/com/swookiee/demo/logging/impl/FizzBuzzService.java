package com.swookiee.demo.logging.impl;

import com.swookiee.demo.logging.FizzBuzz;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class FizzBuzzService implements FizzBuzz {

    private static final Logger logger = LoggerFactory.getLogger(FizzBuzzService.class);

    @Override
    public List<String> fizzbuzz(final Integer limit) {
        if (limit > 10000) {
            throw new WebApplicationException("Naaa... to complicated!", Response.Status.BAD_REQUEST);
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

        Map<String, Object> map = new HashMap<>();
        map.put("limit", limit);
        map.put("result", result);
        logger.info("{}", map);

        return result;
    }
}
