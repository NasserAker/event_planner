package StepsDefinition;

import applicationclasses.Venue;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class venuestep {
    private Venue newVenue;

    @Given("there are available venues")
    public void thereAreAvailableVenues() {
        // Initialize available venues for testing
        Venue.initializeAvailableVenues();
    }

    @When("I view the list of available venues")
    public void iViewTheListOfAvailableVenues() {
        // Implement code to view available venues (not needed for testing)
    }

    @Then("I should see a list of venues")
    public void iShouldSeeAListOfVenues() {
        // Implement code to verify that a list of venues is displayed (not needed for testing)
    }

    @When("I add a new venue named {string} with location {string}, capacity {int}, and cost ${int}")
    public void iAddANewVenueNamedWithLocationCapacityAndCost$(String name, String location, int capacity, int cost) {
        // Add a new venue for testing
        newVenue = new Venue(name, location, capacity, cost);
        newVenue.toString();
        newVenue.getName();
        newVenue.getLocation();
        newVenue.getCapacity();
        newVenue.getCost();
        Venue.addVenueToTheList(newVenue);

    }

    @Then("the new venue should be added to the list of available venues")
    public void theNewVenueShouldBeAddedToTheListOfAvailableVenues() {
        // Verify that the new venue is added to the list of available venues
        assertTrue(Venue.getAvailableVenues().contains(newVenue));
    }

    @Then("the new venue {string} should have location {string}, capacity {int}, and cost ${int}")
    public void theNewVenueShouldHaveLocationCapacityAndCost$(String name, String location, int capacity, int cost) {
        // Get the added venue from the list
        Venue addedVenue = Venue.getAvailableVenues().stream()
                .filter(v -> v.getName().equals(name))
                .findFirst()
                .orElse(null);

        // Verify that the added venue exists
        assertNotNull(addedVenue);

        // Verify the details of the added venue
        assertEquals(name, addedVenue.getName());
        assertEquals(location, addedVenue.getLocation());
        assertEquals(capacity, addedVenue.getCapacity());
        assertEquals(cost, addedVenue.getCost(), 0.01); // Using delta for double comparison
    }
}
