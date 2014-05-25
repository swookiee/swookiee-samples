package com.swookiee.demo.metrics.impl;

import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;
import com.swookiee.demo.metrics.FizzBuzz;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

@Component
public class FizzBuzzService implements FizzBuzz {

    private Meter bizzFuzzMeter;
    private ServiceRegistration<MetricRegistry> registeredMetricRegistry;

    @Activate
    public void activate(BundleContext bc) {
        MetricRegistry metricRegistry = new MetricRegistry();
        this.bizzFuzzMeter = metricRegistry.meter("BizzFuzz");

        Dictionary<String, String> properties = new Hashtable<>();
        properties.put("metricPrefix", "OSGi.DevCon");
        this.registeredMetricRegistry = bc.registerService(MetricRegistry.class, metricRegistry, properties);
    }

    @Deactivate
    public void deactivate() {
        this.registeredMetricRegistry.unregister();
    }

    @Override
    public List<String> fizzbuzz(final Integer limit) {
        if (limit > 10000) {
            throw new WebApplicationException("Naaa... to complicated!", Response.Status.BAD_REQUEST);
        }
        List<String> result = new ArrayList<>();

        for (int k = 1; k <= limit; k++) {
            if (k % 15 == 0) {
                result.add("FizzBuzz");
                this.bizzFuzzMeter.mark();
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
