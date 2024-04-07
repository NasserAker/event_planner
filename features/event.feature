@hala
Feature: Event Management

  Scenario: Initialize event list
    Given the event list is initialized
    Then the event list should not be empty

  Scenario: Add new event
    Given an event with name "wedding" and price 200, availability 100, description "bighall", location "rafidia", and time 15
    When the admin adds the event
    Then the event "wedding" should be added to the event list

  Scenario: Retrieve event by name
    Given the event list is initialized
    When I retrieve the event by name "Event1"
    Then the event with name "Event1" should be returned