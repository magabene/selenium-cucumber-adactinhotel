Feature: User Login
  As a user
  I want to log into the application
  So that I can access my account

  Background:
    Given I am on the login page

  Scenario: Successful login with valid credentials
    When I enter username
    And I enter password
    And I click the login button
    Then I should be redirected to the home page