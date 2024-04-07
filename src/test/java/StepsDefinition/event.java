package StepsDefinition;

import applicationclasses.Event;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static org.junit.Assert.*;

public class event {
    private Event event;
    private List<Event> events;

    @Given("the event list is initialized")
    public void the_event_list_is_initialized() {
        Event.initializeEvents();
    }

    @Then("the event list should not be empty")
    public void the_event_list_should_not_be_empty() {
        events = Event.getAllEvents();
        assertFalse("Event list should not be empty", events.isEmpty());
    }

    @Given("an event with name {string} and price {int}, availability {int}, description {string}, location {string}, and time {int}")
    public void an_event_with_name_and_price_availability_description_location_and_time(String name, int price, int availability, String description, String location, int time) {
        event = new Event(name, price, availability, description, location, time);
    }

    @When("the admin adds the event")
    public void the_admin_adds_the_event() {
        Event.addEvent(event);
    }

    @Then("the event {string} should be added to the event list")
    public void the_event_should_be_added_to_the_event_list(String name) {
        events = Event.getAllEvents();
        boolean found = false;
        for (Event e : events) {
            if (e.getEventName().equals(name)) {
                found = true;
                break;
            }
        }
        assertTrue("Event should be added to the event list", found);
    }

    @When("I retrieve the event by name {string}")
    public void i_retrieve_the_event_by_name(String name) {
        event = Event.retrieveEventByName(name);
    }

    @Then("the event with name {string} should be returned")
    public void the_event_with_name_should_be_returned(String name) {
        assertNotNull("Event should not be null", event);
        assertEquals("Retrieved event name should match", name, event.getEventName());
    }


}
