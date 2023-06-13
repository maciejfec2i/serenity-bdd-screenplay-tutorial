package swaglabs.tasks.authentication;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ui.Button;
import swaglabs.model.SwagLabsUser;

public class Login {
    public static Performable as(SwagLabsUser swagLabsUser) {
        return Task.where("{0} logs in as a " + swagLabsUser,
                Enter.theValue(swagLabsUser.username).into("#user-name"),
                Enter.theValue(swagLabsUser.password).into("#password"),
                Click.on(Button.withNameOrId("login-button"))
        );
    }
}
