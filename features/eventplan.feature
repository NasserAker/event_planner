Feature: Event Planning Management

  Scenario: Creating an Event Plan
    Given an event plan with name "Birthday Party", price 100, availability 50, description "Celebrate John's birthday", location "Community Center", time 18, and theme "Superheroes"
    Then the event plan should be created successfully
