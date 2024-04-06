package StepsDefinition;

import applicationclasses.ReservationRequest;
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

        // Create a calendar instance and set it to the current date and time
        Calendar calendar = Calendar.getInstance();

        // Define the range of days (e.g., within the next 365 days for 1 year)
        int daysInTheFuture = 1 + random.nextInt(365); // 1 to 365 days in the future

        // Add the random number of days to the current date
        calendar.add(Calendar.DAY_OF_YEAR, daysInTheFuture);

        // Get the future date
        Date futureDate = calendar.getTime();

        // Format the future date if you want to output it as a string
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String futureDateString = dateFormat.format(futureDate);

        date = futureDateString;
//        Venue.reserveVenue(date);

        System.out.println("Random future date: " + futureDateString);

    }
    @When("I submit the reservation request")
    public void i_submit_the_reservation_request() {
       // request = new ReservationRequest();
    }
    @Then("the a reservation request should be sent to the service provider")
    public void the_a_reservation_request_should_be_sent_to_the_service_provider() {
        ReservationRequest.RequestList.add(request);
    }
    @Then("I should receive a response with details")
    public void i_should_receive_a_response_with_details() {
            Assert.assertTrue(ReservationRequest.ApprovedRequests.contains(request));
    }

    @When("I attempt to submit a reservation request without specifying the date and time")
    public void i_attempt_to_submit_a_reservation_request_without_specifying_the_date_and_time() {
        date = null;
    }
    @Then("the reservation should not be submitted")
    public void the_reservation_should_not_be_submitted() {
        Assert.assertNotNull(date);
    }
    @Then("I should be prompted to specify the date and time")
    public void i_should_be_prompted_to_specify_the_date_and_time() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a Date (dd-MM-yyyy): ");
        date = scanner.nextLine();
    }


    @Given("I have successfully reserved a venue")
    public void i_have_successfully_reserved_a_venue() {

    }
    @When("I choose to cancel my reservation")
    public void i_choose_to_cancel_my_reservation() {

    }
    @Then("the reservation should be canceled")
    public void the_reservation_should_be_canceled() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("I should receive confirmation that the reservation has been canceled")
    public void i_should_receive_confirmation_that_the_reservation_has_been_canceled() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
