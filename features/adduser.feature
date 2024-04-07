@nasser
Feature: Add User
  Scenario: Adding a new user
    Given there are no existing users
    When a new user with email "example@example.com", username "example_user", address "123 Street", and phone "1234567890" is added
    Then the user should be added successfully

  Scenario: Adding a user with existing email
    Given there are existing users
    When a new user with email "existing@example.com", username "new_user", address "456 Avenue", and phone "9876543210" is added
    Then the user should not be added and return false

