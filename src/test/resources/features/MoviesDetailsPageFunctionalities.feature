Feature: Movies Details Page Functionalities
  As a user of the Movies app website
  I want to be able to access my account
  So that I can check Movies details of the both Home page and Popular page


  Scenario: Test the Movie UI elements of the Home Page
    Given I am on the Home Page
    When I click to the Home Page of Movie image element
    And I check to the Title details
    And I check to the Genres category details
    And I check to the Audio category details
    And I check to the Rating category details
    And I check to the Budget category details
    And I check to the Similar Movies heading
    And I check to the Similar Movies list

  Scenario: Test the Movie UI elements of the Popular Page
    Given I am on the Home Page
    When I navigate to the Popular page
    Then I click to the Popular Page of Movie image element
    And I check to the Title details
    And I check to the Genres category details
    And I check to the Audio category details
    And I check to the Rating category details
    And I check to the Budget category details
    And I check to the Similar Movies heading
    And I check to the Similar Movies list
