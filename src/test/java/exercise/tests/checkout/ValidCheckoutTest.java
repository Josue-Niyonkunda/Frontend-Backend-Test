package exercise.tests.checkout;

import exercise.data.DataLoader;
import exercise.data.MessageLoader;
import exercise.base.BaseTest;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static exercise.assertions.Locators.successfulMsgLocator;


public class ValidCheckoutTest extends BaseTest {
    MessageLoader msg=MessageLoader.getInstance();
    DataLoader dataLoader=DataLoader.getInstance();
    LoginPage login = new LoginPage(page);
    ProductsPage products = new ProductsPage(page);
    CartPage cart = new CartPage(page);
    CheckoutPage checkout = new CheckoutPage(page);

    @Test
    public void continueCheckout(){
        login.login(dataLoader.getUserName(), dataLoader.getPassword());
        products.addBackpack();
        products.addBikeLight();
        products.goToCart();

        cart.checkout();

        checkout.fillInformation(dataLoader.getFirstName(), dataLoader.getLastName(), dataLoader.getZipCode());
        checkout.continueCheckout();
        assertThat(successfulMsgLocator()).hasText(msg.successfulCheckoutMsg());
    }
    @Test
    public void CancelCheckout(){
        login.login(dataLoader.getUserName(), dataLoader.getPassword());

        products.addBackpack();
        products.addBikeLight();
        products.goToCart();

        cart.checkout();

        checkout.fillInformation(dataLoader.getFirstName(), dataLoader.getLastName(), dataLoader.getZipCode());
        checkout.cancel();
        assertThat(successfulMsgLocator()).hasText(msg.cancelCheckoutMsg());
    }





}
