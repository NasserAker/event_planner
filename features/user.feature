Feature: User

  Scenario: Customer edits their profile
    Given I'm the Customer
    And my name is "hala"
    When I entered new password "123"
    Then Your information Updates successfully

  Scenario: Customer views order history and installation requests
    Given I'm the Customer
    When my name is "hala"
    Then The information should appear