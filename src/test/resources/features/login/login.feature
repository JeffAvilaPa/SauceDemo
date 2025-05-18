@smoke @regression
Feature: Login Functionality

  @smoke @positive
  Scenario: Successful login with valid credentials
    Given the user is on the login page
    When the user enters valid username "standard_user" and password "secret_sauce"
    And clicks on the login button
    Then the user should be redirected to the home page

  @regression @negative
  Scenario: Login with invalid credentials
    Given the user is on the login page
    When the user enters invalid username or password
    And clicks on the login button
    Then an error message "Epic sadface: Username and password do not match any user in this service" should be displayed

  @regression @negative
  Scenario: Login with empty fields
    Given the user is on the login page
    When the user clicks on the login button without filling in the fields
    Then a required field warning "Epic sadface: Username is required" should be shown
