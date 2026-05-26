package exercise.assertions;


import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;
import exercise.base.BaseTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    public static Locator getWishlist(){
        return  page.get().locator(".btn-icon.relative[href='/wishlist']");
    }
    public static Locator categoryTitleLocator(String product) {
        Locator msg=getPage().getByText(product).first();
        msg.waitFor();
        return msg;
    }
public static List<String> productPrices() {

    String n = page.get().locator(
            ".flex-1.min-w-0",
            new Page.LocatorOptions().setHas(
                    page.get().locator(".font-display.font-semibold.text-white").last()
            )
    ).filter(new Locator.FilterOptions().setHasText("$")).innerText();
    List<String> prices = new ArrayList<>();
    //extract prices from the big string
    java.util.regex.Matcher matcher =
            java.util.regex.Pattern.compile("(\\$\\d+(\\.\\d{1,2})?)(\\s*\\$\\d+(\\.\\d{1,2})?)?").matcher(n);

    while (matcher.find()) {
        prices.add(matcher.group(1));

    }
    page.get().waitForLoadState();

    return prices;
}
}

