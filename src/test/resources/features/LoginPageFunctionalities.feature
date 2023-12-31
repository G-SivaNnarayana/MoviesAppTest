Feature: Login Page Functionality
  As a user of the Movies app website
  I want to be able to login to my account
  So that I can check the Login page UI and Functionalities

  Scenario: Test the Login Page UI
    Given I am on the login page
    When I checked the Website logo image is displayed or not
    And Test the Heading text is 'Login' or not
    And Test the Username label text is 'USERNAME' or not
    And Test the Password label text is 'PASSWORD' or not
    And Test the Login button is selected or not

  Scenario: Login with empty input fields
    Given I am on the login page
    When I click on the login button
    Then an error message '*Username or password is invalid' should be visible

  Scenario: Login with empty Username field
    Given I am on the login page
    When I enter a valid Password
    And I click on the login button
    Then an error message '*Username or password is invalid' should be visible

  Scenario: Login with empty Password field
    Given I am on the login page
    When I enter a valid Username
    And I click on the login button
    Then an error message '*Username or password is invalid' should be visible

  Scenario: Login with Invalid Password
    Given I am on the login page
    When I enter a valid Username
    And I enter Invalid Password
    And I click on the login button
    Then an error message '*username and password didn't match' should be visible

  Scenario: Successful Login

    Given I am on the login page
    When I enter a valid Username
    And I enter a valid Password
    And I click on the login button
    Then I should be redirected to the homepage