package StepsDefinition;

import ApplicationClasses.User;
import ApplicationClasses.event;
import ApplicationClasses.login;
import ApplicationClasses.reserve;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;

public class reservereq {

    public login obj;
    String uname, dateee , cname;
    public reservereq(login iobj){
        super();
        this.obj = iobj;
        User u1= new User("hala","123","4\1\2004");
        obj.addUser(u1);
        event c2 = new event("wedding",5000,1,"bighall","rafidia",12,"blackandwhite");
        obj.addevent(c2);
        c2.setAvailable(100);
    }
    @Given("My name is {string}")
    public void my_name_is(String name) {
        uname = name;
    }

    @Given("I'm on the reservation request page")
    public void i_m_on_the_reservation_request_page() {
        obj.setreserve(true);
    }

    @When("the customer fills in the following details: event is {string} and date {string}")
    public void the_customer_fills_in_the_following_details_event_is_and_date(String string, String string2) {
        obj.fillModelAndDate(string,string2);
        cname=obj.getCname();
        dateee=obj.getDateee();
    }

    @When("submits the form")
    public void submits_the_form() {
        obj.setSubmit(true);
        obj.addres(new reserve(uname, cname,dateee));
    }

    @Then("the request should be successfully submitted if the date available")
    public void the_request_should_be_successfully_submitted_if_the_date_available() {
        assertTrue("The reservation request submitted", obj.getreservation() && obj.getAvailable1() && obj.getAvailable2() && obj.getSubmit());
    }

    @Then("the request should not be submitted if the date is not available")
    public void the_request_should_not_be_submitted_if_the_date_is_not_available() {
        assertTrue("The reservation request isn't submitted", obj.getreservation() && obj.getAvailable1() && obj.getAvailable2() && obj.getSubmit());
    }
}
