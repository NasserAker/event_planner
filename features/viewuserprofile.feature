Feature: View User Profile

@nasser
  Scenario: User views their own profile
    Given the user is logged in
    When they choose to view their profile
    Then they should see their profile information