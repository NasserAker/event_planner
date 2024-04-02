Feature: admin Catalog

  @hala
  Scenario: Categories
    Given I'm the admin
    When the name is "wedding" and the price is 5000 and the num of av p is 1 and the description "big hall" and the loction "rafidia" and the time was 12 and the theme was "blackwhite"
    Then the product is added to the reserve section
@hala
  Scenario: Product listings
    Given I'm the admin
    When I request information about specific reservation by entering its name "wedding"
    Then Make the reserve descriptions, prices, and availability appear

@hala
  Scenario: Search
    Given I'm the admin
    When I request information about reservation by entering there price 1000
    Then List all the products name, categories, availability and descriptions
