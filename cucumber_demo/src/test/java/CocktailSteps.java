package dojo;

import cucumber.api.java.en.*;
import static org.junit.Assert.*;

public class CocktailSteps {
    private Order order;

    @Given("^(.*) who wants to buy a drink$")
    public void someone_who_wants_to_buy_a_drink(String from) {
        order = new Order();
        order.declareOwner(from);
    }

    @When("^an order is declared for (.*)$")
    public void an_order_is_declared_for_someone(String to) {
        order.declareTarget(to);
    }

    @When("^a message saying \"(.*)\" is added$")
    public void a_message_is_added(String message) {
        order.addMessage(message);
    }

    @Then("^there is (\\d+) cocktails in the order$")
    public void verify_number_of_cocktails(int nbCocktails) {
        assertEquals(nbCocktails, order.getCocktails().size());
    }

    @Then("^the ticket must say \"(.*)\"$")
    public void verify_ticket_message(String expected) {
        assertEquals(expected, order.getTicketMessage());
    }
}