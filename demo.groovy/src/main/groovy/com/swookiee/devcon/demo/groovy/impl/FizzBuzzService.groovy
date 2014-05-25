package com.swookiee.devcon.demo.groovy

import com.swookiee.devcon.demo.groovy.FizzBuzzGroovy
import java.util.ArrayList
import java.util.List
import javax.ws.rs.Path
import javax.ws.rs.WebApplicationException
import org.osgi.service.component.annotations.Component

@Component
public class FizzBuzzService implements FizzBuzzGroovy {

    @Override
    List<String> fizzbuzz(final Integer limit) {
        if (limit > 10000) {
            throw new WebApplicationException("Naaa... to complicated!", Response.Status.BAD_REQUEST);
        }

        def result = []

        for (i in 1..limit) {
            result << ("${i%3?'':'Fizz'}${i%5?'':'Buzz'}" ?: i)
        }
        result as String[]
    }
}
