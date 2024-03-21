Feature: User Profile Management

  Scenario: View user profile
    Given the user is logged in
    When they navigate to the profile page
    Then they should see their profile details

  Scenario: Update user profile
    Given the user is logged in
    When they update their profile information
    And they submit the changes
    Then they should see a success message
    And their profile should be updated accordingly

  Scenario: Change password
    Given the user is logged in
    When they navigate to the change password page
    And they enter their current password and new password
    And they submit the change password form
    Then they should see a success message
    And they should be able to login with the new password
