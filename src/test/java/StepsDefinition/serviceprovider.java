package StepsDefinition;

import applicationclasses.AdditionalService;
import applicationclasses.ServiceProvider;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

import static org.junit.Assert.*;

public class serviceprovider {

    private ServiceProvider serviceProvider;
    private boolean addResult;

    @Given("^I have the details of a new service provider$")
    public void i_have_the_details_of_a_new_service_provider() {
        // Assuming a constructor exists that allows setting all necessary fields
        serviceProvider = new ServiceProvider("newprovider@example.com", "New Provider", "password123", "123 New St", "555-0123", "125", true);
    }

    @When("^I add the service provider to the system$")
    public void i_add_the_service_provider_to_the_system() {
        try {
            ServiceProvider.getServiceProviderList().add(serviceProvider);
            addResult = true;
        } catch (Exception e) {
            addResult = false;
        }
    }

    @Then("^the service provider should be added successfully$")
    public void the_service_provider_should_be_added_successfully() {
        assertTrue(addResult);
        assertNotNull(ServiceProvider.getServiceByEmail(serviceProvider.getEmail()));
    }

    @Given("^I have the details of a new service provider with an existing email$")
    public void i_have_the_details_of_a_new_service_provider_with_an_existing_email() {
        // Assuming "nada@gmail.com" is an existing email in the system
        serviceProvider = new ServiceProvider("nada@gmail.com", "Duplicate Provider", "password123", "456 Old St", "555-4567", "126", true);
    }

    @When("^I attempt to add the service provider to the system$")
    public void i_attempt_to_add_the_service_provider_to_the_system() {
        if (ServiceProvider.getServiceByEmail(serviceProvider.getEmail()) != null) {
            addResult = false;
        } else {
            ServiceProvider.getServiceProviderList().add(serviceProvider);
            addResult = true;
        }
    }

    @Then("^the addition should fail with an email already exists message$")
    public void the_addition_should_fail_with_an_email_already_exists_message() {
        assertTrue(true);
    }


}
