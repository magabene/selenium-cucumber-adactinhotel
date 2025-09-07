package com.qa.steps;

import org.openqa.selenium.WebDriver;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.utils.ConfigManager;
import com.qa.utils.CustomAssert;
import com.qa.utils.DriverManager;
import io.cucumber.java.en.*;

public class WebStepDefinitions {
	
	private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    
    public WebStepDefinitions () {
        this.driver = DriverManager.getDriver();
        this.loginPage = new LoginPage(driver);
        this.homePage = new HomePage(driver);
    }
    
    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
    	//Navigation is handled in hooks
        CustomAssert.assertTrue(loginPage.isDisplayedLoginPage(), "Login page is displayed");
    }
    
    @When("I enter username")
    public void i_enter_username() {
    	
        String username = ConfigManager.getProperty("valid_username");
        loginPage.enterUsername(username);
    }
    
    @When("I enter password")
    public void i_enter_password() {
        String password = ConfigManager.getProperty("valid_password");
        loginPage.enterPassword(password);
    }
    
    @When("I click the login button")
    public void i_click_the_login_button() {
        loginPage.clickLogin();
    }
    
    @Then("I should be redirected to the home page")
    public void i_should_be_redirected_to_the_home_page() {
        CustomAssert.assertTrue(homePage.isHomePageDisplayed(), "Home page should be displayed");
    }
    
}