
package StepsDefinition;

import applicationclasses.SessionManager;
import applicationclasses.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static applicationclasses.User.getUserByEmail;
import static org.junit.Assert.assertNotNull;

public class userregisterationstep {

    @Given("there is a registered user")
    public void thereIsARegisteredUser() {
        // Set up a registered user
        User.initializeUsers();
    }

    @When("the user logs in")
    public void theUserLogsIn() {
        // Simulate user login
        User loginUser = User.getUserList().get(0);// Assuming we're logging in the first user for simplicity
        loginUser.getEmail();
        loginUser.getUsername();
        getUserByEmail( "email");
        loginUser.setPassword("rara");
        SessionManager.loginUser(loginUser);
    }

    @Then("the user should be logged in")
    public void theUserShouldBeLoggedIn() {
        // Check if the user is logged in
        assertNotNull(SessionManager.getLoggedInUser());
    }
}
