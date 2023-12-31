Feature: Search Page Functionality
  As a user of the Movies app website
  I want to be able to access to my account
  So that I can check the Search Functionalities

  Scenario: Test the Search Functionalities
    Given I am on the Search Page
    When I click to the Search box
    And I enter a movie names in search box
    And I click to the Search Page button
    Then I find the count of movies