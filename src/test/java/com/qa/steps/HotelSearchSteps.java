package com.qa.steps;

import org.openqa.selenium.WebDriver;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.HotelSearchResultsPage;
import com.qa.utils.ConfigManager;
import com.qa.utils.CustomAssert;
import com.qa.utils.DriverManager;

import io.cucumber.java.en.*;


public class HotelSearchSteps {
	
	private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    private HotelSearchResultsPage hotelSearchResultsPage;
	
    public HotelSearchSteps() {
        this.driver = DriverManager.getDriver();
        //CustomAssert.setDriver(driver);
        this.loginPage = new LoginPage(driver);
        this.homePage = new HomePage(driver);
        this.hotelSearchResultsPage = new HotelSearchResultsPage(driver);
    }
    
	@Given("I have logged into the hotel application")
    public void i_have_logged_into_the_hotel_application() {
		        
        String username = ConfigManager.getProperty("valid_username");
        String password = ConfigManager.getProperty("valid_password");
        
        homePage = loginPage.login(username, password);
        CustomAssert.assertTrue(homePage.isHomePageDisplayed(), "Home page should be displayed after login");
    }

	@When("I select location {string}")
    public void i_select_location(String location) {
        homePage.selectLocationByLabel(location);
    }
	
	@When("I click on the Search button")
    public void i_click_on_the_search_button() {
        homePage.clickSearchButton();
        hotelSearchResultsPage = new HotelSearchResultsPage(driver);
    }
	
	@Then("my results should be hotels in {string}")
    public void my_results_should_be_hotels_in(String location) {
        // Verify results on SearchResultsPage
		CustomAssert.assertTrue(hotelSearchResultsPage.isResultsPageDisplayed(), "Search results page should be displayed");		
		hotelSearchResultsPage.is1stLocationCorrect(location, true); //the value true denotes that we are checking for an exact match
    }
}
