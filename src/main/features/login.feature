Feature: Login
  as a new user i want to login to the program
  so that the system remembers my data

 Scenario : Successful login to the program
   Given A user brings up the login pop-up
   When A user clicks Sign-in
   And A user enters a valid email "hala@gmail.com" and password "1234"
   And A user clicks enter
   Then A user should be successfully logged into the site

  Scenario : Unsuccessful Login to the program
    Given A user brings up the login pop-up
    When A user enters an invalid email "hala@gmail.com" and password "1234"
    And A user clicks enter
    Then A user should not be successfully logged into the site

  Scenario : Forgot Password
    Given the user is on the login screen
    When they tap the "Forgot Password" button
    Then they should be taken to the password reset screen