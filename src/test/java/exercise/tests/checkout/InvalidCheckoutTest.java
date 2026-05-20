package exercise.tests.checkout;





import exercise.data.DataLoader;
import exercise.data.MessageLoader;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;
import exercise.base.BaseTest;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static exercise.assertions.Locators.errorMsgLocator;

public class InvalidCheckoutTest extends BaseTest {
    DataLoader data= DataLoader.getInstance();
    MessageLoader message= MessageLoader.getInstance();
    LoginPage login = new LoginPage(page);
    ProductsPage products = new ProductsPage(page);
    CartPage cart = new CartPage(page);
    CheckoutPage checkout = new CheckoutPage(page);

    @Test
    public void checkoutWithoutFirstname(){
        MessageLoader message=MessageLoader.getInstance();
        login.login(data.getUserName(),data.getPassword());


        products.addBackpack();
        products.addBikeLight();
        products.goToCart();

        cart.checkout();
        checkout.fillInformation(data.getEmptyData(), data.getLastName(), data.getZipCode());
        checkout.continueCheckout();


        assertThat(errorMsgLocator()).hasText(message.firstNameErrorMsg());
    }
    @Test
    public void checkoutWithoutLastname(){
        login.login(data.getUserName(), data.getPassword());

        CheckoutPage checkout = new CheckoutPage(page);
        products.addBackpack();
        products.addBikeLight();
        products.goToCart();

        cart.checkout();
        checkout.fillInformation(data.getFirstName(), data.getEmptyData(),data.getZipCode());
        checkout.continueCheckout();


        assertThat(errorMsgLocator()).hasText(message.lastNameErrorMessage());
    }
    @Test
    public void checkoutWithoutZipCode(){
        login.login(data.getUserName(), data.getPassword());

        CheckoutPage checkout = new CheckoutPage(page);
        products.addBackpack();
        products.addBikeLight();
        products.goToCart();

        cart.checkout();
        checkout.fillInformation(data.getFirstName(), data.getLastName(), data.getEmptyData());
        checkout.continueCheckout();

        assertThat(errorMsgLocator()).hasText(message.zipCodeErrorMessage());
    }
}
