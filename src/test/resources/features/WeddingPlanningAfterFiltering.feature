Feature: Wedding Planning After Filtering

    Scenario: User Actions After Filtering Wedding Dates and Venues
        Given the user has filtered wedding dates and venues based on their preferences
        When they choose to take actions after filtering
        Then they should be able to view detailed information about filtered venues
        And they should be able to make a reservation for a selected date and venue
        And they should be able to refine their filters to further narrow down options
        And they should be able to explore other features such as guest management, budget tracking, vendor options, or personalized recommendations
        And they should be able to exit the filtering system and return to the main menu of the wedding planning application
