package StepsDefinition;

import ApplicationClasses.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertNotNull;


public class viewuserstep {
    User u = new User ("username", "password", "address", "phone", "email", "gender");
    @Given("the user is logged in")

    public void the_user_is_logged_in() {
        // Write code here that turns the phrase above into concrete actions
        u.logging(true);}

    @When("they choose to view their profile")
    public void they_choose_to_view_their_profile() {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("they should see their profile information")
    public void they_should_see_their_profile_information() {
        // Write code here that turns the phrase above into concrete actions
        assertNotNull(u.getUsername());
        assertNotNull(u.getAddress());
        assertNotNull(u.getPhone());
        assertNotNull(u.getGender());

    }
}
