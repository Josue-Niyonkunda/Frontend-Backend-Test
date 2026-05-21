package exercise.assertions;


import com.microsoft.playwright.Locator;
import exercise.base.BaseTest;

public class Locators extends BaseTest {
    public static Locator productsAddedToCart(){
     return    page.get().locator("button.btn-icon.relative");
    }

}
