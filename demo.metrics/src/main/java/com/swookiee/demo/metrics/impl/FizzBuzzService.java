package com.swookiee.demo.metrics.impl;

import com.swookiee.demo.metrics.FizzBuzz;
import com.swookiee.runtime.metrics.prometheus.CollectorCollection;
import io.prometheus.client.Collector;
import io.prometheus.client.Counter;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.*;

@Component
public class FizzBuzzService implements FizzBuzz, CollectorCollection {

    private final Counter counter = Counter.build().name("fizzbuzz_total").help("Demo Metrics").create();

    @Activate
    public void activate(BundleContext bc) {
        Dictionary<String, String> properties = new Hashtable<>();
        properties.put("metricPrefix", "OSGi.DevCon");
    }

    @Override
    public List<String> fizzbuzz(final Integer limit) {
        if (limit > 10000) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        List<String> result = new ArrayList<>();

        for (int k = 1; k <= limit; k++) {
            if (k % 15 == 0) {
                result.add("FizzBuzz");
                this.counter.inc();
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

    @Override
    public List<Collector> getCollectors() {
        return Arrays.asList(counter);
    }
}
