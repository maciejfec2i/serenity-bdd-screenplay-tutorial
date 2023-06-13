package swaglabs.tasks.cart;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import org.openqa.selenium.By;

public class CartCount {

    private static final By SHOPPING_CART_BADGE = By.className("shopping_cart_badge");

    public static Question<Integer> currentlyDisplayed() {
        return Text.of(SHOPPING_CART_BADGE).asInteger();
    }
}
