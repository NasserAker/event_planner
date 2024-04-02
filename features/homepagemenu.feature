Feature: Home Page Menu

  Scenario: Display Home Page Menu
    Given the user is on the home page
    When the user is prompted with the home page menu
    Then the user should see the following options:
      | 1. Create account |
      | 2. Log-in         |
      | 3. Exit           |
