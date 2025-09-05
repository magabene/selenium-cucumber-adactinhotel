package com.qa.pages;

import com.qa.utils.ConfigManager;
import com.qa.utils.CustomAssert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigManager.getPropertyAsInt("implicit_wait")));
        PageFactory.initElements(driver, this);
        CustomAssert.setDriver(driver); //Set driver for CustomAssert class
    }
    
    public void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
    
    public void type(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
    }
    
    public String getText(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }
    
    public void selectDropdownOption(WebElement element, String option, String method) {
        WebElement visibleElement = wait.until(ExpectedConditions.visibilityOf(element));
        Select dropdown = new Select(visibleElement);
        switch (method.toLowerCase()) {
            case "text":
                dropdown.selectByVisibleText(option);
                break;
            case "value":
                dropdown.selectByValue(option);
                break;
            case "index":
                dropdown.selectByIndex(Integer.parseInt(option));
                break;
            default:
                throw new IllegalArgumentException("Invalid selection method: " + method + ". Use 'text', 'value', or 'index'.");
        }
    }
    
    public boolean isDisplayed(WebElement element) {
        try {
            return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
        
    }
    
    //Verify the presence of specified text in an element
    public void verifyElementText(WebElement element, String expectedText, boolean exactMatch) {
        WebElement visibleElement = wait.until(ExpectedConditions.visibilityOf(element));
        String actualText = visibleElement.getText().trim();
        if (exactMatch) {
            CustomAssert.assertEquals("Element text does not match expected value", expectedText, actualText);
        } else {
            CustomAssert.assertTrue(actualText.toLowerCase().contains(expectedText.toLowerCase()),
            		"Element text does not contain expected value: " + expectedText
                              );
        }
    }
    
    //Verify the value of an element
    public void verifyElementValue(WebElement element, String expectedValue, boolean exactMatch) {
        WebElement visibleElement = wait.until(ExpectedConditions.visibilityOf(element));
        String actualValue;
        
        // Check if element is a <select> dropdown
        if (visibleElement.getTagName().equalsIgnoreCase("select")) {
            Select select = new Select(visibleElement);
            actualValue = select.getFirstSelectedOption().getAttribute("value");
        } else {
            actualValue = visibleElement.getAttribute("value");
        }
        
        if (actualValue == null) {
            throw new IllegalStateException("Element does not have a 'value' attribute or selected option: " + element);
        }
        
        if (exactMatch) {
            CustomAssert.assertEquals(actualValue.trim(), expectedValue, 
                "Element value does not match expected value: " + expectedValue);
        } else {
            CustomAssert.assertTrue(actualValue.toLowerCase().contains(expectedValue.toLowerCase()),
                "Element value does not contain expected value: " + expectedValue);
        }
    }
}