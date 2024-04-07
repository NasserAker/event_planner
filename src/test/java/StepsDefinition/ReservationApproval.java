package StepsDefinition;

import applicationclasses.*;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ReservationApproval {
    ReservationRequest request , request1 , request2 ,selectedRequest;
    Venue venue;

    public ReservationApproval(){
        User user = new User("hala","123","rafdia","24342","halaa","female");
        Date date = new Date(2002, 12, 12);
        venue = new Venue("name" , "location", 150  , 1500 );
        AdditionalService service= new AdditionalService("cake",12.0);

        List<AdditionalService> services = new ArrayList<>();
        services.add(service);

        this.request = new ReservationRequest(1, user, venue, date, services);
        this.request1 = new ReservationRequest(2, user, venue, date , services);
        this.request2 = new ReservationRequest(3, user ,venue, date , services);
        Venue.addVenueToTheList(venue);
    }

    @Given("there are pending reservation requests")
    public void there_are_pending_reservation_requests() {
        ReservationRequest.addToRequestList(request);
        ReservationRequest.addToRequestList(request1);
        ReservationRequest.addToRequestList(request2);
    }

    @When("I select a pending reservation request")
    public void i_select_a_pending_reservation_request() {
        List<ReservationRequest> list = ReservationRequest.getAllReservationRequests();
        Random random = new Random();
        // Generate a random number from {0, 1, 2}
        int randomNumber = random.nextInt(ReservationRequest.getRequestList().size());
        ReservationRequest temp ;
        temp = ReservationRequest.getRequestList().get(randomNumber);

        selectedRequest = temp;
    }

    @When("I click on the {string} button")
    public void i_click_on_the_button(String string) {
        List<Venue> list  = Venue.getAvailableVenues() ;
        if(string.equals("Approve") && list.contains(venue)){
            selectedRequest.approveRequest();
            System.out.println("Approved");
        }
        else {
            selectedRequest.denyRequest();
            System.out.println("Denied");
        }
    }

    @Then("the requester should receive a confirmation message")
    public void the_requester_should_receive_a_confirmation_message() {
        Assert.assertTrue(selectedRequest.isConfirmed());
    }


    @Then("the requester should receive a notification with the denial and the reason")
    public void the_requester_should_receive_a_notification_with_the_denial_and_the_reason() {
        Assert.assertTrue(selectedRequest.isDenied());
    }


}
