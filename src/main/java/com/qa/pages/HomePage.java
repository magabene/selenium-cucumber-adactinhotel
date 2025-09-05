package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    
	//Welcome text 
    @FindBy(className = "welcome_menu")
    private WebElement welcomeText;
    
    //Username display field
    @FindBy(id = "username_show")
    private WebElement usernameDisplay;
    
    //Location select drop down
    @FindBy(id = "location")
    private WebElement hotelLocation;
    
    //Search button
    @FindBy(id ="Submit")
    private WebElement searchButton;
    
    public HomePage(WebDriver driver) {
		// Inherit driver from super class
    	super(driver);
	}

	//checks if welcome text is displayed
    public boolean isHomePageDisplayed() {
        return isDisplayed(welcomeText);
    }
    
    //checks if username is displayed
    public boolean isUsernameDisplayed() {
        return isDisplayed(usernameDisplay);
    }
    
    //selects location by text
    public void selectLocationByLabel(String option) {
    	selectDropdownOption(hotelLocation, option, "text");
    }
    
    //Click search button
    public void clickSearchButton() {
    	click(searchButton);
    }
}