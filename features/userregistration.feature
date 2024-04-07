Feature: User Registration
  As a potential user
  I want to register for an account
  So that I can access the system

  Scenario: Successful user registration
    Given there is a registered user
    When the user logs in
    Then the user should be logged in
