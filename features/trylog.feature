Feature: Admin logging
   Admin during his logging into the system goes through several cases


  Scenario: successful login to the program
    Given that the admin is not logged in
    And the password is "1234"
    Then the login operation succeeds
    And the admin is logged in

  Scenario: unsuccessful login to the program
    Given that the admin is not logged in
    And the password is "Wrong_password"
    Then the login operation fails
    And the admin is not logged in

  Scenario: forget password
    Given that the admin is not logged in
    And the password is "Wrong_password" or the email is "wrong_email"
    Then the login operation fails
    And the admin is not logged in


  Scenario: Admin logs out
    Given that the admin  name "hala" is logged in
    When the admin logs out
    Then the admin is not logged in

  Scenario: reset password
    Given a password reset request,
    When I follow the password reset process,
    Then I should be able to set a new password.