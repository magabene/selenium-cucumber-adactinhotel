package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HotelSearchResultsPage extends BasePage{
	
	@FindBy(xpath = "//*[@id=\"select_form\"]/table/tbody/tr[1]/td")
    private WebElement resultsHeader;
	
	//Search results location column, 1st row
	@FindBy(id ="location_1")
	private WebElement locationOneResult;
	
	public HotelSearchResultsPage(WebDriver driver) {
		//Inherit driver from super class
		super(driver);
	}

	//Verify the 1st location displayed
	public void is1stLocationCorrect(String text, boolean exactMatch) {
		 verifyElementValue(locationOneResult, text, exactMatch);
	}
	
	public boolean isResultsPageDisplayed() {
        return isDisplayed(resultsHeader);
    }
}
