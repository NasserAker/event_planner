package StepsDefinition;

import ApplicationClasses.login;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class notification {
    public login obj;
    public boolean place = false;
    public boolean update = false;
    public boolean ready = false;
    public notification(login iobj){
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
        try {
            Properties properties = System.getProperties();
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.port", "587");
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");

            Session session = Session.getDefaultInstance(properties,new javax.mail.Authenticator(){
                @Override
                protected PasswordAuthentication getPasswordAuthentication(){
                    return new PasswordAuthentication("s12112519@stu.najah.edu\n","kbd@35376");
                }
            });
            session.setDebug(true);
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("s12112519@stu.najah.edu\n"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient,false));
            message.setSubject("Software Engineer");
            message.setText("Event planner");
            Transport.send(message);
        }
        catch (MessagingException m){
            m.printStackTrace();
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
