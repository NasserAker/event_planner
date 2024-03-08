package StepsDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.admin;
import org.example.login;


public class loginstep {
    login user;
    admin a;
public loginstep(){
    user = new login();
    a=new admin("naseraker4@gmail.com","nasser","1234");
    user.getQ().put("naseraker4@gmail.com","1234");
    user.setY(0);

}

    @Given("that the admin is not logged in")
    public void that_the_admin_is_not_logged_in() {

    }

    @Given("the password is {string}")
    public void the_password_is(String string) {

    }

    @Then("the org.example.login operation succeeds")
    public void the_login_operation_succeeds() {

    }

    @Then("the admin is logged in")
    public void the_admin_is_logged_in() {

    }

    @Then("the org.example.login operation fails")
    public void the_login_operation_fails() {

    }

    @Then("the admin is not logged in")
    public void the_admin_is_not_logged_in() {

    }

    @Given("the password is {string} or the email is {string}")
    public void the_password_is_or_the_email_is(String string, String string2) {

    }

    @Given("that the admin  name {string} is logged in")
    public void that_the_admin_name_is_logged_in() {
        user.setlogin(true);

    }

    @When("the admin logs out")
    public void the_admin_logs_out() {

    }

    @Given("a password reset request,")
    public void a_password_reset_request() {

    }

    @When("I follow the password reset process,")
    public void i_follow_the_password_reset_process() {

    }

    @Then("I should be able to set a new password.")
    public void i_should_be_able_to_set_a_new_password() {

    }



}
