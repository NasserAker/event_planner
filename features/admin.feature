Feature: Admin
  #@hala
  Scenario: adding a events
    Given I'm the admin
    When the name is "wedding" and the price is 5000 and the num of av p is 1 and the description "big hall"
    Then the event add successfully
  #@hala
  Scenario: view customer account
    Given I'm the admin
    When the admin asks to get all the customer account
    Then the customers accounts ust be appear on the screen
  #@hala
  Scenario: change customer's information
    Given I'm the admin
    When I enter the name for user "hala" and the new password is "2345"
    Then The password must change successfully
  #@hala
  Scenario: update reservation
    Given I'm the admin
    When I give the name of reservation "wedding" and the new price for it 4000
    Then The price must change successfully
  #@hala
  Scenario: make a schedule for appointments
    Given I'm the admin
    When I give you a date "10-01-2024"
    Then this date must be added to the appointment as reserved venue