Feature: User Login

  Scenario: Successful login
    Given the user is on the login page
    When they enter valid login credentials
    And they submit the login form
    Then they should be redirected to the dashboard
    And they should see a welcome message

  Scenario: Failed login
    Given the user is on the login page
    When they enter invalid login credentials
    And they submit the login form
    Then they should see an error message
    And they should remain on the login page
