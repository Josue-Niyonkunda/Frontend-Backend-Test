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
    public static Locator logoutMsg() {
        Locator msg = page.get().locator(".font-display.font-semibold.text-lg.text-white");
        msg.waitFor();
        return msg;
    }
   public static String emptyEmailValidation(){
       Locator emailField = getPage().locator("[type='email']");

       return emailField.evaluate(
               "el => el.validationMessage"
       ).toString();

   }
   public static String emptyFirstnameValidation(){
        Locator firstNameField=page.get().locator("[placeholder='First name']");
        return firstNameField.evaluate("el => el.validationMessage").toString();
   }
    public static String emptyPasswordValidation(){
        Locator emailField = getPage().locator("[type='password']");

        return emailField.evaluate(
                "el => el.validationMessage"
        ).toString();

    }
    public static Locator homeValidation(){
       return getPage().getByText("SUMMER COLLECTION IS LIVE");
    }
    public static Locator ShopValidation(){
        return getPage().getByText("All Products");
    }
    public static Locator flashValidation(){
        return getPage().getByText("Flash Sales").first();
    }
    public static Locator featuredValidation(){
        return getPage().getByText("Featured").nth(1);
    }
    public static Locator Orderplacedsuccessfully(){
       return getPage().locator(".go3958317564");

    }
    public static Locator searchLocator(String product) {
        return getPage().getByText("Results for \"" + product + "\"");
    }


}

