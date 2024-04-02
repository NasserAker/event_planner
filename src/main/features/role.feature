Feature: Roles

  Scenario: Admin role
    Given I am in system
    And I'm the admin
    When set user name "hala" and pass "123"
    Then you can Manage products
    And see categories
    And access user accounts


  Scenario: Customer role
    Given I am in system
    And I'm the Customer
    When set user name "nasser" and pass "54321"
    Then You can Browse products
    And Make purchases
    And View orders


  Scenario: service provider role
    Given I am in system
    And I'm the service provider
    When set user name "hala" and pass "123"
    Then You can View reservation requests
    And View schedule appointments