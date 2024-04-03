
Feature: admin Catalog


  Scenario: Categories
    Given I'm the admin
    When the event is "birthday" and total price is 5000 and availabile halls is 1 and descriptions is "essintial part" and the location is "rafidia" a the time is 23 and the theme is "bink"
    Then the reservation is added to the reserve section

  Scenario: Product listings
    Given I'm the admin
    When I request information about specific reservation by entering its name "wedding"
    Then Make the reserve descriptions, prices, and availability appear


  Scenario: Search
    Given I'm the admin
    When I request information about reservation by entering there price 1000
    Then List all the reservation name, categories, availability and descriptions
