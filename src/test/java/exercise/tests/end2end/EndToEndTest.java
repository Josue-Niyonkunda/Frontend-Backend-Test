package exercise.tests.end2end;


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

public class EndToEndTest extends BaseTest {
    DataLoader dataLoader=DataLoader.getInstance();
    MessageLoader msg= MessageLoader.getInstance();
    LoginPage login = new LoginPage(page);
    ProductsPage products = new ProductsPage(page);
    CartPage cart = new CartPage(page);
    CheckoutPage checkout = new CheckoutPage(page);

    @Test
    public void finishTest() {


        login.login(dataLoader.getUserName(), dataLoader.getPassword());

        products.addBackpack();
        products.addBikeLight();
        products.goToCart();

        cart.checkout();

        checkout.fillInformation(dataLoader.getFirstName(), dataLoader.getLastName(), dataLoader.getZipCode());
        checkout.continueCheckout();
        checkout.finishCheckout();

        assertThat(successfulMsgLocator())
                .hasText(msg.checkoutFinishMsg());
    }
    @Test
    public void cancelTest() {

        login.login(dataLoader.getUserName(), dataLoader.getPassword());

        products.addBackpack();
        products.addBikeLight();
        products.goToCart();

        cart.checkout();

        checkout.fillInformation(dataLoader.getFirstName(), dataLoader.getLastName(), dataLoader.getZipCode());
        checkout.continueCheckout();
        checkout.cancel();

        assertThat(successfulMsgLocator())
                .hasText(msg.cancelFinishCheckout());
    }




}
