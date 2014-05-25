package com.swookiee.sample.configuration;

import com.swookiee.runtime.util.configuration.ConfigurationUtils;
import java.net.URL;
import org.osgi.framework.BundleContext;
import org.osgi.service.cm.ConfigurationAdmin;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component
public class ConfigurationProviderSample {

    private ConfigurationAdmin configAdmin;

    @Activate
    public void activate(final BundleContext bundleContext) {

        final URL configurationFile = bundleContext.getBundle().getResource("Configuration.yaml");
        ConfigurationUtils.applyConfiguration(Configuration.class, configurationFile, configAdmin);
    }

    @Reference
    public void setConfigurationAdmin(final ConfigurationAdmin configurationAdmin) {
        this.configAdmin = configurationAdmin;
    }

    public void unsetConfigurationAdmin(final ConfigurationAdmin configurationAdmin) {
        this.configAdmin = null;
    }
}
