package swaglabs.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import swaglabs.tasks.cart.AddToCart;
import swaglabs.tasks.cart.CartContents;
import swaglabs.tasks.cart.CartCount;
import swaglabs.tasks.navigation.Navigate;

import java.util.List;

public class CatalogStepDefinitions {

    @Given("{actor} is browsing the catalog")
    public void actor_is_browsing_the_catalog(Actor actor) {
        actor.attemptsTo(
                Navigate.toTheCatalogPage()
        );
    }

    @When("{actor} adds the following items to the cart:")
    public void actor_adds_the_following_items_to_the_cart(Actor actor, List<String> listOfItems) {
        Serenity.setSessionVariable("numOfItems").to(listOfItems.size());
        Serenity.setSessionVariable("cartItems").to(listOfItems);
        listOfItems.forEach(
                itemName -> actor.attemptsTo(AddToCart.item(itemName))
        );
    }

    @Then("then shopping cart count should be correct")
    public void then_shopping_cart_count_should_be_correct() {
        OnStage.theActorInTheSpotlight()
                .attemptsTo(
                       Ensure.that(CartCount.currentlyDisplayed())
                               .asAnInteger()
                               .isEqualTo(Serenity.sessionVariableCalled("numOfItems"))
                );
    }

    @And("the items should appear in the cart")
    public void the_items_should_appear_in_the_cart() {
        List<String> cartItems = Serenity.sessionVariableCalled("cartItems");

        OnStage.theActorInTheSpotlight()
                .attemptsTo(
                        Navigate.toTheShoppingCart(),
                        Ensure.that(CartContents.currentlyDisplayed())
                                .containsElementsFrom(cartItems)
                );
    }
}
