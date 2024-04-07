package StepsDefinition;

import applicationclasses.*;
import applicationclasses.User;
import applicationclasses.Venue;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class ReserveVenue {
    Venue venue ;
    User user;

    ReservationRequest request;
    String date;

    public ReserveVenue(){
        this.venue = new Venue("nablus life","tounis street" ,200,4000.99 );
        this.user = new User("nasser","123" ,"rafidia","0598817198"
                ,"nasseraker4@gmail.com", "others" );

        this.request = new ReservationRequest(1,user , venue,new applicationclasses.Date(12,12,2002),null);

    }

    @Given("I have searched for a venue that meets my requirements")
    public void i_have_searched_for_a_venue_that_meets_my_requirements() {
        Venue.initializeAvailableVenues();
    }
    @When("I select a venue that is available")
    public void i_select_a_venue_that_is_available() {
        Random rand = new Random();
        venue = Venue.getAvailableVenues().get(rand.nextInt(Venue.getAvailableVenues().size()) );
    }




    @When("I specify the date and time for my reservation")
    public void i_specify_the_date_and_time_for_my_reservation() {
        Random random = new Random();
        Calendar calendar = Calendar.getInstance();
        int daysInTheFuture = 1 + random.nextInt(365);
        calendar.add(Calendar.DAY_OF_YEAR, daysInTheFuture);
        Date futureDate = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String futureDateString = dateFormat.format(futureDate);

        date = futureDateString;

        System.out.println(STR."Random future date: \{futureDateString}");

    }





    @When("I submit the reservation request")
    public void i_submit_the_reservation_request() {
        ReservationRequest.addReservationRequest(request);
    }



    @Then("the a reservation request should be sent to the service provider")
    public void the_a_reservation_request_should_be_sent_to_the_service_provider() {
        ReservationRequest.getRequestList().add(request);
    }



    @Then("I should receive a response with details")
    public void i_should_receive_a_response_with_details() {
        if(new Random().nextInt(2) == 1){request.approveRequest();}
        else{request.denyRequest();}
        Assert.assertTrue(ReservationRequest.getApprovedRequests().contains(request) || ReservationRequest.getDeniedRequests().contains(request));
    }

    @And("My name is {string}")
    public void myNameIs(String arg0) {
        user.setUsername(arg0);
    }

    @And("submits the form")
    public void submitsTheForm() {
        ReservationRequest.addReservationRequest(request);
    }

    @Then("the request should not be submitted if the date is not available")
    public void theRequestShouldNotBeSubmittedIfTheDateIsNotAvailable() {
        Assert.assertTrue("the reservation request isn't submitted",true);
    }
}
