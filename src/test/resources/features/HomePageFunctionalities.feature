Feature:Home Page Functionality
  As a user of the Movies app website
  I want to be able to access my account
  So that I can check the Home page Functionalities

  Scenario: Test the Home Page Functionalities
    Given I am on the Home Page
    When I check to the Heading text of each section
    And I check to the Movies or displayed or not
    And I check to the Contact Us Section

  Scenario: Test the Header Section UI
    Given I am on the Home Page
    When I check to the Website logo is displayed or not
    And I check to the Navbar Home element
    And I check to the Navbar Popular element
    And I check to the Navbar Search button element
    And I check to the Navbar Account element

  Scenario: Test the Header Section Functionalities
    Given I am on the Home Page
    When I navigate to the Popular page
    And I navigate to the Home Page
    And I navigate to the Account Page
