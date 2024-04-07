Feature: the user should be able to make a reservation for a chosen venue



  Scenario: Choosing and reserving an available venue
    Given I have searched for a venue that meets my requirements
    When I select a venue that is available
    And I specify the date and time for my reservation
    And I submit the reservation request
    Then the a reservation request should be sent to the service provider
    And I should receive a response with details



  Scenario: Customer submits an invalid reservation request
    Given I'm the Customer
    And My name is "nasser"
    When I select a venue that is available
    And  submits the form
    Then the request should not be submitted if the date is not available