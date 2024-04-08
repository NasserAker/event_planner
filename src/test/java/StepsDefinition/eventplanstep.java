package StepsDefinition;
import applicationclasses.EventPlan;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertEquals;
public class eventplanstep {

    private EventPlan eventPlan;

    @Given("an event plan with name {string}, price {int}, availability {int}, description {string}, location {string}, time {int}, and theme {string}")
    public void anEventPlanWithNamePriceAvailabilityDescriptionLocationTimeAndTheme(String name, int price, int availability, String description, String location, int time, String theme) {

        eventPlan = new EventPlan(name, price, availability, description, location, time, theme);
//eventPlan.setAvailable();

    }


    @Then("the event plan should be created successfully")
    public void theEventPlanShouldBeCreatedSuccessfully() {
        assertEquals("Birthday Party", eventPlan.geteventName());
        assertEquals(100, eventPlan.getPrice());
        assertEquals(50, eventPlan.getAvailable());
        assertEquals("Celebrate John's birthday", eventPlan.getDescrtion());
        assertEquals("Community Center", eventPlan.getlocation());
        assertEquals(18, eventPlan.gettime());
        assertEquals("Superheroes", eventPlan.gettheme());
    }

}
