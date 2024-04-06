package StepsDefinition;
import applicationclasses.eventplan;
import applicationclasses.login;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class admincat {
    public login obj;
    public boolean added = false;
    public eventplan cc=new eventplan();

    public admincat(login iobj){
        super();
        this.obj = iobj;
        eventplan c1 = new eventplan("wedding",5000,1,"bighall","rafidia",12,"blackandwhite");
        obj.addevent(c1);
    }

    @When("the event is {string} and total price is {int} and availabile halls is {int} and descriptions is {string} and the location is {string} a the time is {int} and the theme is {string}")
    public void the_event_is_and_total_price_is_and_availabile_halls_is_and_descriptions_is_and_the_location_is_a_the_time_is_and_the_theme_is(String nam, int price, int ava, String desc,String loc,int time,String theme) {
        obj.catagoryadd(nam,price,ava,desc,loc,time,theme);
        added=true;
    }

    @Then("the reservation is added to the reserve section")
    public void the_reservation_is_added_to_the_reserve_section() {
        assertTrue("The reservation is added",added);
    }

    @When("I request information about specific reservation by entering its name {string}")
    public void i_request_information_about_specific_reservation_by_entering_its_name(String name) {
        obj.searchbyname(name);
    }

    @Then("Make the reserve descriptions, prices, and availability appear")
    public void make_the_reserve_descriptions_prices_and_availability_appear() {
        assertNotNull(cc);
        obj.printCatalog(cc);
    }

    @When("I request information about reservation by entering there price {int}")
    public void i_request_information_about_reservation_by_entering_there_price(Integer price) {
        obj.requestByPrice(price);
    }

    @Then("List all the reservation name, categories, availability and descriptions")
    public void list_all_the_reservation_name_categories_availability_and_descriptions() {
        assertNotNull(obj.geteventArrayList());
    }
}
