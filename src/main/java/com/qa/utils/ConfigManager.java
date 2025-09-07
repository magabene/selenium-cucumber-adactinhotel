/**
 * @author Justice Mohuba
 * @date 03/09/2025
 */
package com.qa.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Justice Mohuba
 * @date 03/09/2025
 */
public class ConfigManager {
	private static Properties properties = new Properties();
    private static final String CONFIG_FILE_PATH = "src/test/resources/config/config.properties";
    
    static {
        loadProperties();
    }

    private static void loadProperties() {
        try {
            // Load main config
            FileInputStream fis = new FileInputStream(CONFIG_FILE_PATH);
            properties.load(fis);
            fis.close();
            
            // Load environment specific config
            String environment = properties.getProperty("environment", "dev"); //provides fallback for missing properties by providing a default value
            String envConfigPath = "src/test/resources/config/" + environment + ".properties";
            
            FileInputStream envFis = new FileInputStream(envConfigPath);
            properties.load(envFis);
            envFis.close();
            
        } catch (IOException e) {
            throw new RuntimeException("Failed to load configuration properties", e);
        }
    }
    
    public static String getProperty(String key) {
        String value = System.getProperty(key);
        return value != null ? value : properties.getProperty(key);  //Override file based properties at runtime by getting system properties
    }
    
    public static int getPropertyAsInt(String key) {
        return Integer.parseInt(getProperty(key));
    }
    
    public static boolean getPropertyAsBoolean(String key) {
        return Boolean.parseBoolean(getProperty(key));
    }
}

