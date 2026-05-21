package exercise.assertions;


import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.SelectOption;
import exercise.base.BaseTest;

public class Locators extends BaseTest {
    public static Locator productsAddedToCart(){
     return    page.get().locator("button.btn-icon.relative");
    }
   public static  Locator accountCreationMsg(){

       return getPage().locator(".go3958317564");
   }
}

