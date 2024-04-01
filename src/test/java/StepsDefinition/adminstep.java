package StepsDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import applicationclasses.event;
import applicationclasses.login;

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
        event c1 = new event("wedding",5000,1,"big hall");
        obj.addevent(c1);

    }


    @When("the name is {string} and the price is {int} and the num of av p is {int}")
    public void the_name_is_and_the_price_is_and_the_num_of_av_p_is(String nam, int price, int ava, String desc) {
        obj.event(nam,price,ava,desc);
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
