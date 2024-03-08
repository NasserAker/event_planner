Feature: Dates Available

  Description:
  This feature allows users to view available dates for wedding venues independently of the
  venue search and filtering process. Users can either choose a date first and then see the available venues
  or select a venue first and then view the available dates for that venue.

  Scenario: User chooses a date and views available venues
    Given the user is on the "Dates Available" page
    When the user selects a specific date from the calendar
    Then the system displays a list of available wedding venues for that selected date

