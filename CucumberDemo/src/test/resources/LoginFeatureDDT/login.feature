Feature: Login functionality

  Scenario Outline: invalid login
    Given login page is open
    When invalid data is entered in "<uname>" and "<passwd>"
    And Signin button is clicked
    Then Error message should be displayed

    Examples: 
      | uname | passwd |
      | user1 | pass1  |
      | user2 | pass2  |
      | user3 | pass3  |
