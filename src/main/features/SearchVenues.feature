Feature: Venues Available

    Description:
    This feature allows users to view available venues for wedding events.
    Users can select a specific venue to see the available dates for that venue.

    Scenario: User views available venues
        Given the user is on the "Venues Available" page
        When the user navigates to the page
        Then the system displays a list of available wedding venues