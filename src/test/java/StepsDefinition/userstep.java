package StepsDefinition;

import applicationclasses.Login;
import applicationclasses.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class userstep {
    public Login obj;
    public String name;
    public  String pass;

    public userstep(Login iobj){
        super();
        this.obj = iobj;
    }
    @Given("my name is {string}")
    public void my_name_is(String string) {
        name = string;
    }

    @When("I entered new password {string}")
    public void i_entered_new_password(String string) {

        pass = string;
    }

    @Then("Your information Updates successfully")
    public void your_information_updates_successfully() {
        obj.updatesSuccessfully(name,pass);
        assertTrue("Your information Updates successfully", obj.getUpdates());
    }


    @Then("The information should appear")
    public void the_information_should_appear() {
        assertTrue("Your information appeared successfully", obj.getApear());
    }

}