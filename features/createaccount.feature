Feature: Create Account
@nasser
  Scenario: User creates a new account
    Given the user is on the home page
    When the user chooses to create a new account
    And the user enters their details
    Then the user account should be created successfully
    And the user should be logged in