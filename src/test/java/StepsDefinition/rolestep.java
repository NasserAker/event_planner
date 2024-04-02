package StepsDefinition;

import ApplicationClasses.login;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class rolestep {
    public login obj;
    private String userRole;
    public rolestep(login iobj) {
        super();
        this.obj = iobj;
    }

    @Given("I am in system")
    public void i_am_in_system() {
        obj.setLogged(true);
    }

    @When("set user name {string} and pass {string}")
    public void set_user_name_and_pass(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("you can Manage products")
    public void you_can_manage_products() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("see categories")
    public void see_categories() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("access user accounts")
    public void access_user_accounts() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("You can Browse products")
    public void you_can_browse_products() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Make purchases")
    public void make_purchases() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("View orders")
    public void view_orders() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("I'm the service provider")
    public void i_m_the_service_provider() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("You can View reservation requests")
    public void you_can_view_reservation_requests() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("View schedule appointments")
    public void view_schedule_appointments() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
