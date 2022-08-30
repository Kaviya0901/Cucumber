Feature: Login functionality

  Scenario: invalid login
    Given login page is open
    When  invalid data is entered in Username and Password
    And   Signin button is clicked
    Then  Error message should be displayed
