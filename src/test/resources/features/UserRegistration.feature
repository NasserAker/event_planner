Feature: User Registration

  Scenario: New user registration
    Given the user is on the registration page
    When they enter valid registration details
    And they submit the registration form
    Then they should see a success message
    And they should be logged in

  Scenario: Existing user registration
    Given the user is on the registration page
    When they enter existing email address
    And they submit the registration form
    Then they should see an error message
    And they should not be logged in
