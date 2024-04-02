package StepsDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ApplicationClasses.event;
import ApplicationClasses.login;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class adminstep {
    public login obj;
    int CustList =0;
    public boolean updates =  false;
    public boolean appears = false;
    public String name;
    public adminstep(login iobj)
    {
        super();
        this.obj=iobj;
        event c1 = new event("wedding",5000,1,"bighall","rafidia",12,"blackandwhite");
        obj.addevent(c1);

    }

    @Given("I'm the admin")
    public void iMTheAdmin() {
        obj.iMTheAdmin(obj);
    }


    @When("the name is {string} and the price is {int} and the num of av p is {int} and the description {string} and the loction {string} and the time was {int} and the theme was {string}")
    public void theNameIsAndThePriceIsAndTheNumOfAvPIsAndTheDescription(String nam, int price, int ava, String desc,String loc,int time,String theme) {
        obj.event(nam,price,ava,desc,loc,time,theme);
        name =nam;
    }

    @Then("the event add successfully")
    public void the_event_add_successfully() {
        obj.addeve(name);
        assertEquals(1, obj.getE());
    }

    @When("the admin asks to get all the customer account")
    public void the_admin_asks_to_get_all_the_customer_account() {
        obj.seeUser();
        CustList =1;
    }

    @Then("the customers accounts ust be appear on the screen")
    public void the_customers_accounts_ust_be_appear_on_the_screen() {
        assertEquals(1, CustList);
    }

    @When("I enter the name for user {string} and the new password is {string}")
    public void i_enter_the_name_for_user_and_the_new_password_is(String string, String string2) {
        updates= (obj.update(string,string2) == 1);
    }

    @Then("The password must change successfully")
    public void the_password_must_change_successfully() {
        assertTrue(updates);
    }

    @When("I give the name of reservation {string} and the new price for it {int}")
    public void i_give_the_name_of_reservation_and_the_new_price_for_it(String name, int newprice) {
        obj.newPrice(name,newprice);
    }

    @Then("The price must change successfully")
    public void the_price_must_change_successfully() {
        assertEquals(1, obj.getCheck());
    }

    @When("I give you a date {string}")
    public void i_give_you_a_date(String string) {
        obj.addDate(string);
    }

    @Then("this date must be added to the appointment as reserved venue")
    public void this_date_must_be_added_to_the_appointment_as_reserved_venue() {
        assertTrue(true);
    }

}
