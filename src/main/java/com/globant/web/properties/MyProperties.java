package com.globant.web.properties;

import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.util.Properties;

@Slf4j
public class MyProperties {
    public Properties retrieveProperties() {
        try {
            java.util.Properties property = new java.util.Properties();
            InputStream input = this.getClass().getResourceAsStream("/config.properties");
            property.load(input);
            return property;
        } catch (Exception e) {
            log.error("Error loading properties file.");
        }
        return null;
    }

    public String getProperty(String key){
        return retrieveProperties().getProperty(key);
    }
}
