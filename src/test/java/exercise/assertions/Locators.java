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
   public static String emptyEmailValidation(){
       Locator emailField = getPage().locator("[type='email']");

       return emailField.evaluate(
               "el => el.validationMessage"
       ).toString();

   }
    public static String emptyPasswordValidation(){
        Locator emailField = getPage().locator("[type='password']");

        return emailField.evaluate(
                "el => el.validationMessage"
        ).toString();

    }
}

