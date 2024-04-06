#
#@nasser

Feature: Venue Reservation
  As a user, I want to be able to make a reservation for a venue so that I can ensure the venue is available for my event.

#@nasser
  Scenario: Choosing and reserving an available venue
    Given I have searched for a venue that meets my requirements
    When I select a venue that is available
    And I specify the date and time for my reservation
    And I submit the reservation request
    Then the a reservation request should be sent to the service provider
    And I should receive a response with details



#  @nasser
  Scenario: Trying to reserve a venue without specifying date and time
    Given I have searched for a venue that meets my requirements
    When I select a venue that is available
    And I attempt to submit a reservation request without specifying the date and time
    Then the reservation should not be submitted
    And I should be prompted to specify the date and time


  #@nasser
  Scenario: Reserving a venue and then canceling the reservation
    Given I have successfully reserved a venue
    When I choose to cancel my reservation
    Then the reservation should be canceled
    And I should receive confirmation that the reservation has been canceled




