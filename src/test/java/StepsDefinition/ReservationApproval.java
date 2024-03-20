package StepsDefinition;

import io.cucumber.java.en.*;
import ApplicationClasses.ReservationRequest;
import org.junit.Assert;

public class ReservationApproval {
    ReservationRequest request;
    int requestCount;
    Integer selectedRequest;

    public ReservationApproval(){
        this.request = new ReservationRequest();
    }

    @Given("there are pending reservation requests")
    public void there_are_pending_reservation_requests() {
        requestCount = request.RequestCount();
    }

    @When("I select a pending reservation request")
    public void i_select_a_pending_reservation_request() {

        for (int i = 1; i <= 5; i++) {
            ReservationRequest.RequestList.add(i);
        }
        selectedRequest = request.SelectRequest(requestCount);
    }

    @When("I click on the {string} button")
    public void i_click_on_the_button(String string) {
        Assert.assertNotEquals(0, (int) selectedRequest);
        if(string.equals("Approve")){
            request.ApproveRequest();
            System.out.println("Approved");
        }
        else {
            request.DenyRequest();
            System.out.println("Denied");
        }
    }

    @Then("the requester should receive a confirmation message")
    public void the_requester_should_receive_a_confirmation_message() {
        Assert.assertTrue(request.Confirmation());
    }


    @Then("the requester should receive a notification with the denial and the reason")
    public void the_requester_should_receive_a_notification_with_the_denial_and_the_reason() {

        Assert.assertTrue(request.Denial());
    }


}
