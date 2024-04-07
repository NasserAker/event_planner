@hala
Feature: Adding a new Service Provider

  In order to manage service providers efficiently
  As an application user
  I want to be able to add new service providers to the system

  Scenario: Add a valid new service provider
    Given I have the details of a new service provider
    When I add the service provider to the system
    Then the service provider should be added successfully

  Scenario: Attempt to add a service provider with an existing email
    Given I have the details of a new service provider with an existing email
    When I attempt to add the service provider to the system
    Then the addition should fail with an email already exists message
