package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class CheckoutPage {
    public CheckoutPage(ThreadLocal<Page> page) {
        this.page = page;
    }

    private final ThreadLocal<Page>page;
   public void clickCheckoutButton() {
       Locator checkout = page.get().locator("a.btn-primary", new Page.LocatorOptions().setHasText("Checkout"));
       page.get().waitForTimeout(1500);
       checkout.waitFor();
       checkout.click();
   }
    public void clickBasket(){
       page.get().locator(".lucide.lucide-shopping-bag").first().click();
    }
    public void  AddNewAddress(){
       page.get().getByText("Add new address").click();

    }
    public void fillOutDeliveryAddress(
            String firstName,String lastName,
            String phone,String streetAddress,
            String city,String state,
            String country){
        page.get().locator("[placeholder='First name']").fill(firstName);
        page.get().locator("[placeholder='Last name']").fill(lastName);
        page.get().locator("[placeholder='Phone number']").fill(phone);
        page.get().locator("[placeholder='Street address']").fill(streetAddress);
        page.get().locator("[placeholder='City']").fill(city);
        page.get().locator("[placeholder='State / Region']").fill(state);
        page.get().locator("[placeholder='Country']").fill(country);


    }
    public void  SaveAddress(){
        page.get().getByText(" Save Address").click();
    }
    public void clickContinueButton(){
       page.get().getByText("Continue to Payment ").click();
    }
    public void clickPay_when_your_order_arrives(){
       page.get().getByText("Pay when your order arrives").click();
    }
    public void clickReviewOrder(){
       page.get().getByText("Review Order ").click();
    }
    public void clickPlaceOrder(){
        page.get().getByRole(
                AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName("Place Order")
        ).click();
    }



}
