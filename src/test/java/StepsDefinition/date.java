package StepsDefinition;
import applicationclasses.Date;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import static org.junit.Assert.assertEquals;
import java.util.List;
public class date {

    @Given("^I have initialized available dates$")
    public void initializeAvailableDates() {
        Date.initializeAvailableDates();
    }

    @Then("^I should have available dates for version (\\d+)$")
    public void verifyAvailableDates(int version) {
        List<Date> availableDates;
        switch (version) {
            case 1:
                availableDates = Date.availableDatesV1;
                break;
            case 2:
                availableDates = Date.availableDatesV2;
                break;
            case 3:
                availableDates = Date.availableDatesV3;
                break;
            case 4:
                availableDates = Date.availableDatesV4;
                break;
            case 5:
                availableDates = Date.availableDatesV5;
                break;
            default:
                throw new IllegalArgumentException("Invalid version number");
        }

        // For demonstration purposes, you can check the size of availableDates
        // You can add more assertions based on your requirements
        assertEquals(5, availableDates.size());
    }

}
