Feature: reservation Requests
# 2 tests failed
  Scenario: Customer submits an reservation request
    Given I'm the Customer
    And My name is "hala"
    And  I'm on the reservation request page
    When the customer fills in the following details: event is "wedding" and date "02-04-2024"
    And submits the form
    Then the request should be successfully submitted if the date available


  Scenario: Customer submits an invalid reservation request
    Given I'm the Customer
    And My name is "nasser"
    And  I'm on the reservation request page
    When the customer fills in the following details: event is "birthday" and date "01-04-2024"
    And  submits the form
    Then the request should not be submitted if the date is not available