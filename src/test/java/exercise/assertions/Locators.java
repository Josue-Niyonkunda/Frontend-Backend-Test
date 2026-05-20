package exercise.assertions;

import com.microsoft.playwright.Locator;
import exercise.base.BaseTest;


public class Locators extends BaseTest {
    public static Locator errorMsgLocator(){
        return page.get().locator("[data-test='error']");
    }
    public static Locator successfulMsgLocator(){
        return page.get().locator("[data-test='title']");
    }
}
