package StepsDefinition;

import io.cucumber.java.en.*;
import ApplicationClasses.ReservationRequest;
import org.junit.Assert;

public class ReservationApproval {
    ReservationRequest request;

    public ReservationApproval(ReservationRequest req){
        this.request = req;
    }

    @Given("there are pending reservation requests")
    public void there_are_pending_reservation_requests() {

    }

    @When("I select a pending reservation request")
    public void i_select_a_pending_reservation_request() {

    }

    @When("I click on the {string} button")
    public void i_click_on_the_button(String string) {
        if(string.equals("Approve")){
          request.ApproveRequest();
        }
        else {
            request.DenyRequest();
        }
    }

    @Then("the requester should receive a confirmation message")
    public void the_requester_should_receive_a_confirmation_message() {
        request.sendConfirmation();
    }


    @Then("the requester should receive a notification with the denial and the reason")
    public void the_requester_should_receive_a_notification_with_the_denial_and_the_reason() {
        request.sendDenial();
    }
}
