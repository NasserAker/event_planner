package StepsDefinition;

import applicationclasses.EmailSender;
import applicationclasses.Login;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class notification {
    private final EmailSender emailSender = new EmailSender();
    public Login obj;
    public boolean place = false;
    public boolean update = false;
    public boolean ready = false;
    public notification(Login iobj){
        super();
        this.obj = iobj;
    }

    @Given("I'm the Customer")
    public void i_m_the_customer() {
        obj.imthecustomer(obj);
    }

    @Given("I have placed an order")
    public void i_have_placed_an_order() {
        place = obj.getreservation() && obj.getAvailable1() && obj.getAvailable2() && obj.getSubmit();
    }

    @When("the order is confirmed and updates are available")
    public void the_order_is_confirmed_and_updates_are_available() {

        update = true;

    }

    @Then("Send email to {string}")
    public void send_Email_To(String recipient) {
        if (update) { // Check if updates are available before sending email
            emailSender.email(recipient, "Your order has been confirmed.");
        }

    }

    @Given("I'm the server provider")
    public void i_m_the_server_provider() {
        obj.imtheserverprovider(obj);
    }

    @When("the request is ready to be assigned to an server provider")
    public void the_request_is_ready_to_be_assigned_to_an_server_provider() {
        ready = true;
    }

}
