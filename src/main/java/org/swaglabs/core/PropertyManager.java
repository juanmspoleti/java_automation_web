package org.swaglabs.core;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyManager {

    private static final String PROPERTY_FILE_NAME = "config.properties";

    private static Properties properties;

    private static Properties getProperties() {
        if (properties == null) {
            try {
                loadProperties();
            } catch (IOException e) {
                Logger.getLogger(PropertyManager.class).error(">>>Properties file could not be loaded: ".concat(e.getLocalizedMessage()));
                throw new RuntimeException("Properties file could not be loaded");
            }
        }
        return properties;
    }

    public static String getProperty(String propertyKey) {
        return getProperties().getProperty(propertyKey);
    }

    private static void loadProperties() throws IOException {
        properties = new Properties();
        InputStream inputStream = PropertyManager.class.getClassLoader().getResourceAsStream(PROPERTY_FILE_NAME);
        properties.load(inputStream);
    }
}
