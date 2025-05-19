@smoke @regression
Feature: Dashboard validation

  @smoke @regression
  Scenario: Validate dashboard after successful login
    Given the user is on the login page
    When the user enters valid username "standard_user" and password "secret_sauce"
    And clicks on the login button
    Then the dashboard should be visible
    And the page title should be "Products"
    And there should be 6 products displayed

  @regression @dashboard @sorting
  Scenario: Products are sorted by Name (Z to A)
    Given the user is on the login page
    When the user enters valid username "standard_user" and password "secret_sauce"
    And clicks on the login button
    And selects "Name (Z to A)" from the sort dropdown
    Then the products should be sorted by name in descending order

  @regression @dashboard @sorting
  Scenario: Products are sorted by Price (Low to High)
    Given the user is on the login page
    When the user enters valid username "standard_user" and password "secret_sauce"
    And clicks on the login button
    And selects "Price (low to high)" from the sort dropdown
    Then the products should be sorted by price in ascending order

  @regression @dashboard @sorting
  Scenario: Products are sorted by Price (High to Low)
    Given the user is on the login page
    When the user enters valid username "standard_user" and password "secret_sauce"
    And clicks on the login button
    And selects "Price (high to low)" from the sort dropdown
    Then the products should be sorted by price in descending order


