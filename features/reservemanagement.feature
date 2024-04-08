Feature: Reservation Management

  Scenario: Creating a Reservation
    Given a user with username "john" reserves a spot for event "Wedding" on date "2024-04-15"
    Then the reservation should be created successfully
