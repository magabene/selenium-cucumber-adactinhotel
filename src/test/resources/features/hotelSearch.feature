Feature: Hotel search
As a user 
I want to search hotels
Using the search parameters provided

Scenario: Search hotel by location successfully
	Given I have logged into the hotel application
	When I select location "Melbourne"
	And I click on the Search button
	Then my results should be hotels in "Melbourne"
	