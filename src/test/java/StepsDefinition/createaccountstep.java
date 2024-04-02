package StepsDefinition;

import ApplicationClasses.SessionManager;
import Main.ProductionCode;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class createaccountstep {

    @Given("the user is on the home page")
    public void the_user_is_on_the_home_page() {
        // Implement code to navigate to the home page
        ProductionCode.homePage();
    }

    @When("the user chooses to create a new account")
    public void the_user_chooses_to_create_a_new_account() {
        // Implement code to choose to create a new account
    }

    @When("the user enters their details")
    public void the_user_enters_their_details() {
        // Implement code to enter user details
        ProductionCode.createAccountPage();
    }

    @Then("the user account should be created successfully")
    public void the_user_account_should_be_created_successfully() {
        // Check if the user account was created successfully
        boolean accountCreated = ProductionCode.createAccountPage();

        assertTrue("User account should be created successfully", accountCreated);
    }
    @Then("the user should be logged in")
    public void the_user_should_be_logged_in() {
        // Check if the user is logged in after creating the account
        assertNotNull("User should be logged in", SessionManager.getLoggedInUser());
    }
}
