package StepsDefinition;

import ApplicationClasses.event;
import ApplicationClasses.login;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class admincatalogstep {
    public login obj;
    public boolean added = false;
    public event cc=new event();
    public String Categorie;
    public admincatalogstep(login iobj){
        super();
        this.obj = iobj;
        event c1 = new event("wedding",5000,1,"bighall","rafidia",12,"blackandwhite");

    }

    @Then("the product is added to the reserve section")
    public void the_product_is_added_to_the_reserve_section() {
        assertTrue("The product is added",added);
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

    @Then("List all the products name, categories, availability and descriptions")
    public void list_all_the_products_name_categories_availability_and_descriptions() {
        assertNotNull(obj.geteventArrayList());
    }
}
