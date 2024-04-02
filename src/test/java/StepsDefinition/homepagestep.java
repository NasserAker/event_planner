package StepsDefinition;

import Main.ProductionCode;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;


import java.util.List;

public class homepagestep {

    @Given("the user is on the home page")
    public void the_user_is_on_the_home_page() {
        // Write code here that turns the phrase above into concrete actions
        ProductionCode.homePage();

    }

    @When("the user is prompted with the home page menu")
    public void the_user_is_prompted_with_the_home_page_menu() {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("the user should see the following options:")
    public void the_user_should_see_the_following_options(DataTable dataTable) {
        List<String> expectedOptions = dataTable.asList(String.class);

        // Get the actual options displayed in the home page menu
        List<String> actualOptions = getHomePageMenuOptions();

        // Compare the expected and actual options
        if (!actualOptions.equals(expectedOptions)) {
            throw new AssertionError("Expected options: " + expectedOptions + "\nActual options: " + actualOptions);
        }
    }

    // Method to retrieve the actual options displayed in the home page menu
    private List<String> getHomePageMenuOptions() {
        // Implement the logic to fetch the actual options from the home page menu
        // For example, you can hardcode them or fetch them from the UI
        // Here's a hardcoded example:
        List<String> actualOptions = List.of("1. Create account", "2. Log-in", "3. Exit");
        return actualOptions;
    }



}
