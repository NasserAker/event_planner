Feature: Filter Wedding Dates and Venues Sequentially

    Scenario: Filter by Venue First
        Given the user is on the venue filtering page
        When they choose to filter by venue
        And they select a specific venue
        Then they should see available dates for that venue

    Scenario: Filter by Date after Venue Selection
        Given the user has filtered wedding venues
        When they choose to filter by date
        And they select a specific date
        Then they should see available venues for that date

    Scenario: Filter by Date First
        Given the user is on the date filtering page
        When they choose to filter by date
        And they select a specific date
        Then they should see available venues for that date

    Scenario: Filter by Venue after Date Selection
        Given the user has filtered wedding dates
        When they choose to filter by venue
        And they select a specific venue
        Then they should see available dates for that venue
