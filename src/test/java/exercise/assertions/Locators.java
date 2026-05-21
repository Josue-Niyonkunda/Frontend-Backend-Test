package exercise.assertions;


import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.SelectOption;
import exercise.base.BaseTest;

public class Locators extends BaseTest {
    public static Locator productsAddedToCart(){
     return    page.get().locator("button.btn-icon.relative");
    }
   public static  Locator accountCreationMsg(){
//       Locator emailMessage= getPage().locator("svg.lucide.lucide-user");
//       emailMessage.hover();
//       return getPage().locator(".text-sm.text-white.truncate");
       return getPage().locator(".go3958317564");
   }
//   public static Locator emailAlreadyCreated(){
//
//        return getPage().locator(".go3958317564");
//   }
}
