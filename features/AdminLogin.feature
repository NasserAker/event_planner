
Feature: when the user enters an email and he is an admin he should be entered as an admin


  @run
  Scenario: the admin login using his email
    Given an admin logs in
    When his email and passwords are correct
    Then he successfully logs in

