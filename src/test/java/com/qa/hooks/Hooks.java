package com.qa.hooks;

import com.qa.utils.ConfigManager;
import com.qa.utils.CustomAssert;
import com.qa.utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
    
    @Before
    public void setup() {
        String browser = System.getProperty("browser", ConfigManager.getProperty("browser"));
        DriverManager.initializeDriver(browser);
        DriverManager.getDriver().get(ConfigManager.getProperty("url"));
        CustomAssert.setDriver(DriverManager.getDriver());
    }
    
    @Before("@api")
    public void beforeApiScenario() {
        // API-specific setup if needed
    }
    
    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println("Scenario failed: " + scenario.getName());
        }
        
        // Clean up WebDriver
        DriverManager.quitDriver();
    }
}