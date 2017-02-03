package com.swookiee.demo.configuration;

import com.swookiee.runtime.authentication.AdminUserConfiguration;

/*
 * This is a simple POJO which will be filled from the Configuration.yaml from src/main/resources
 */
public class Configuration {

    /**
     * We also want to change the default username and pasword for the felix
     * console and the remote API
     */
    public AdminUserConfiguration adminUserConfiguration;

}
