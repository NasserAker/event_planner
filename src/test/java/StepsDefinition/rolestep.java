package StepsDefinition;

import applicationclasses.login;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;

public class rolestep {
    public login obj;
    private String userRole="";
    public rolestep(login iobj) {
        super();
        this.obj = iobj;
    }

    @Given("I am in system")
    public void i_am_in_system() {
        obj.setLogged(true);
    }

    @When("set user name {string} and pass {string}")
    public void set_user_name_and_pass(String user_name, String pass) {
        obj.setNamePass(user_name,pass);
    }

    @Then("you can Manage events")
    public void you_can_manage_products() {
        assertTrue("Admin can manage events", obj.getIsLogged() && userRole.equals("admin"));
    }

    @Then("see categories")
    public void see_categories() {
        assertTrue("Admin can see categories", obj.getIsLogged() && userRole.equals("admin"));
    }

    @Then("access user accounts")
    public void access_user_accounts() {
        assertTrue("Admin can access user accounts", obj.getIsLogged() && userRole.equals("admin"));
    }

    @Then("You can Browse events")
    public void you_can_browse_products() {
        assertTrue("Customer can browse products",userRole.equals("customer") && obj.getIsLogged());
    }

    @Then("Make purchases")
    public void make_purchases() {
        assertTrue("Customer can make Purchases",userRole.equals("customer") && obj.getIsLogged());
    }

    @Then("View orders")
    public void view_orders() {
        assertTrue("Customer can view orders",userRole.equals("customer") && obj.getIsLogged());
    }

    @Given("I'm the service provider")
    public void i_m_the_service_provider() {
        userRole = "service provider";
    }

    @Then("You can View reservation requests")
    public void you_can_view_reservation_requests() {
        assertTrue("service provider can View reservation requests",userRole.equals("service provider") && obj.getIsLogged());
    }

    @Then("View schedule appointments")
    public void view_schedule_appointments() {
        assertTrue("service provider can View schedule appointments",userRole.equals("service provider") && obj.getIsLogged());
    }

}
