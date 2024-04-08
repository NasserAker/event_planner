package StepsDefinition;

import applicationclasses.Logging;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import applicationclasses.UserPlan;
import applicationclasses.Login;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class loginstep {
    public Login obj;
    public boolean forget = false;
    public String enteredUsername;
    public String enteredPassword;
    Logging log = new Logging();
    Login login = new Login();
    public loginstep(Login iobj) {
        super();
        this.obj = iobj;
        UserPlan u1= new UserPlan("hala","123","1\2\2004");
        obj.addUser(u1);
        UserPlan u2= new UserPlan("magichala.koni@gmail.com","1234","6\12\2003");
        obj.addUser(u2);
    }
    @Given("that the admin is not logged in")
    public void that_the_admin_is_not_logged_in() {
        obj.iAmNotInSystem(obj);

        if(log.searchEmail("john@gmail.com") == 1 ){
            System.out.println("User");
        }
        if(log.searchEmail("nada@gmail.com") == 2 ){
            System.out.println("provider");
        }
        int x = log.searchPassword("123");
        int y = log.searchPassword("321");
    }

    @When("set username {string} and pass {string}")
    public void set_username_and_pass(String username, String pass) {
        obj.setUnandpass(username,pass);
    }

    @Then("the login operation succeeds")
    public void the_login_operation_succeeds() {
        assertTrue("Login should succeed", obj.getValidation());
    }

    @When("set invalid username {string} and pass {string}")
    public void set_invalid_username_and_pass(String username, String pass) {
//        obj.setInvalidUsernameAndPass(username,pass);
    }

    @Then("the login operation fails")
    public void the_login_operation_fails() {
        assertFalse("Login should fail", obj.getValidation());
    }

    @When("set valid username {string} and invalid pass {string}")
    public void set_valid_username_and_invalid_pass(String username, String pass) {
//        obj.setValidUsernameAndInvalidPass(username,pass);
        Login login = new Login();
        boolean b1 = login.getAvailable1();
        boolean b2 = login.getAvailable2();
        boolean b3 = login.getSubmit();
        if(b1&&b2&&b3){
            System.out.println("true");
        }
    }

    @Given("I am not in system")
    public void i_am_not_in_system() {
        obj.iAmNotInSystem(obj);
//        List<String> list = login.getDate();
//        if(list.isEmpty()){
//            System.out.println("empty");
//        }
    }

    @When("set empty username {string} and pass {string}")
    public void set_empty_username_and_pass(String username, String pass) {
        obj.setEmptyUsernameAndPass(username,pass);
    }

    @Then("login failed")
    public void login_failed() {
        assertFalse("Login failed", obj.getValidation());
    }

    @When("set valid username {string} and empty pass {string}")
    public void set_valid_username_and_empty_pass(String username, String pass) {
        obj.setValidUsernameAndEmptyPass(username,pass);
    }

    @When("set valid username {string} and  pass {string}")
    public void set_valid_username_and_pass(String username, String pass) {
        obj.validUserPass(username,pass);
        forget=obj.getForget();
        enteredUsername= obj.getEnteredUsername();
    }

    @Then("take new pass {string}")
    public void take_new_pass(String newPassword) {
        obj.takePass(newPassword);
        assertTrue("New password should be updated", obj.getPasswordUpdated());
    }

    @Given("i don't have an account")
    public void i_don_t_have_an_account() {
        obj.setLogged(false);
    }

    @When("set new username {string} and pass {string} and bd={string}")
    public void set_new_username_and_pass_and_bd(String user_name, String pass,String bd) {
        obj.addUser(new UserPlan(user_name, pass,bd));
        enteredUsername = user_name;
        enteredPassword = pass;
    }

    @Then("create succeed")
    public void create_succeed() {
        obj.createAcc(enteredUsername,enteredPassword);
        assertTrue("User creation should succeed", obj.getUserCreated());
    }



}

