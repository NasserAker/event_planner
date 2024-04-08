package StepsDefinition;
import applicationclasses.Reserve;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertEquals;
public class reservestep
{

    private Reserve reserve;

    @Given("a user with username {string} reserves a spot for event {string} on date {string}")
    public void aUserWithUsernameReservesASpotForEventOnDate(String username, String eventName, String date) {
        reserve = new Reserve(username, eventName, date);
    }

    @Then("the reservation should be created successfully")
    public void theReservationShouldBeCreatedSuccessfully() {
        assertEquals("john", reserve.getUname());
        assertEquals("Wedding", reserve.getCname());
        assertEquals("2024-04-15", reserve.getDate());
    }
}
