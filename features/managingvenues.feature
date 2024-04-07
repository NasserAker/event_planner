Feature: Managing Venues

  Scenario: Viewing available venues
    Given there are available venues
    When I view the list of available venues
    Then I should see a list of venues

  Scenario: Adding a new venue
    When I add a new venue named "Garden" with location "Nazareth", capacity 50, and cost $1000
    Then the new venue should be added to the list of available venues