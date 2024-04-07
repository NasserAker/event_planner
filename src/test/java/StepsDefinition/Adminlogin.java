package StepsDefinition;

import applicationclasses.Admin;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Objects;

public class Adminlogin {
    Admin  admin =new Admin("nasseraker4@gmail.com", "Nasser", "1234");
    String username , password ,email;

    @Given("an admin logs in")
    public void anAdminLogsIn() {
        Admin.initializeAdmin();
        username = admin.getUsername();
        password = admin.getPassword();
        email = admin.getEmail();
    }

    @When("his email and passwords are correct")
    public void hisEmailAndPasswordsAreCorrect() {
        Admin.getAdminByEmail("nasseraker4@gmail.com");
        Admin temp = admin;
        if(username.equals(temp.getUsername()) || password.equals(temp.getPassword())  || email.equals(temp.getEmail()) ){
            admin.logging(true);
        }
    }

    @Then("he successfully logs in")
    public void heSuccessfullyLogsIn() {
        Assert.assertTrue(admin.logged());
    }

}
