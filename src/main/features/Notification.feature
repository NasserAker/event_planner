Feature: Notifications
@hala
  Scenario: Customer receives order confirmation and updates
    Given I'm the Customer
    And I have placed an order
    When the order is confirmed and updates are available
    Then Send email to "magichala.koni@gmail.com"
@hala
  Scenario: server provider receives notification for new reservation requests
    Given I'm the server provider
    When the request is ready to be assigned to an server provider
    Then Send email to "s12112519@stu.najah.edu"