package StepsDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class homepagestep {

    @Given("the user is on the home page")
    public void the_user_is_on_the_home_page() {
        // Write code here that turns the phrase above into concrete actions

    }

    @When("the user is prompted with the home page menu")
    public void the_user_is_prompted_with_the_home_page_menu() {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("the user should see the following options:")
    public void the_user_should_see_the_following_options(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.

    }



}
