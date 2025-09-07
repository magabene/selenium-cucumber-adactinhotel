package com.qa.utils;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CustomAssert {

    private static WebDriver driver; 

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    public static void assertTrue(boolean condition, String message) {
        attachScreenshot("Assertion Evidence: " + message);
        Assert.assertTrue(condition, message);
    }

    public static void assertEquals(Object actual, Object expected, String message) {
        attachScreenshot("Assertion Evidence: " + message);
        Assert.assertEquals(actual, expected, message);
    }

    public static void assertFalse(boolean condition, String message) {
        attachScreenshot("Assertion Evidence: " + message);
        Assert.assertFalse(condition, message);
    }

    private static void attachScreenshot(String name) {
        if (driver != null) {
            ScreenshotUtility.attachScreenshot(driver, name);
        }
    }
}