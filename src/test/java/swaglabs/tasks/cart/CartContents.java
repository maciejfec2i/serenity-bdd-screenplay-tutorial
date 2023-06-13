package swaglabs.tasks.cart;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import org.openqa.selenium.By;

import java.util.Collection;

public class CartContents {

    private static final By INVENTORY_ITEM_NAME = By.className("inventory_item_name");

    public static Question<Collection<String>> currentlyDisplayed() {
        return Text.ofEach(INVENTORY_ITEM_NAME);
    }
}
