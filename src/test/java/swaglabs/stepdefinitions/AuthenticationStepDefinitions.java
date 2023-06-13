package swaglabs.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import swaglabs.tasks.authentication.Login;
import swaglabs.tasks.navigation.Navigate;

import static swaglabs.model.SwagLabsUser.*;

public class AuthenticationStepDefinitions {

    @Given("{actor} is on the login page")
    public void actor_is_on_the_login_page(Actor actor) {
        actor.attemptsTo(
                Navigate.toTheLoginPage()
        );
    }
    @When("{actor} logs in with valid credentials")
    public void actor_logs_in_with_valid_credentials(Actor actor) {
        actor.attemptsTo(
                Login.as(STANDARD_USER)
        );
    }
    @Then("{actor} should be presented with the product catalog")
    public void actor_should_be_presented_with_the_product_catalog(Actor actor) {
        actor.attemptsTo(
                Ensure.that(Text.of(".title")).isEqualToIgnoringCase("products")
        );
    }

    @Given("{actor} has logged in to the application")
    public void actor_has_logged_in_to_the_application(Actor actor) {
        actor.attemptsTo(
                Navigate.toTheLoginPage(),
                Login.as(STANDARD_USER)
        );
    }
}
