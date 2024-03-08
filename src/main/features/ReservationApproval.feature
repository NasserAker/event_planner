Feature: the service provider approve or deny the request to reserve a venue


Scenario: Approving a Reservation
Given there are pending reservation requests
When I select a pending reservation request
And I click on the "Approve" button
Then the requester should receive a confirmation message

Scenario: Denying a Reservation
Given there are pending reservation requests
When I select a pending reservation request
And I click on the "Deny" button
Then the requester should receive a notification with the denial and the reason