Feature: Account Page Functionality
  As a user of the Movies App website
  I want to be able to access my account
  So that I can check the Account Page Functionalities

  Scenario:Test the Account Page Functionalities
    Given I am on the Home Page
    When I navigate to the Account Page
    And I check to the Account heading
    And I check to the Membership Details
    And I check to the Plan Details
    And I check to the Logout Button element

  Scenario: Test the  Logout Functionalities
    Given I am on the Home Page
    When I navigate to the Account Page
    And I click to the Logout Button element
    Then I should redirect to the Login page