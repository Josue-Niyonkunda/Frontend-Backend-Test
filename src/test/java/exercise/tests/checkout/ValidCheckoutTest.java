package exercise.tests.checkout;

import exercise.base.BaseTest;
import exercise.data.DataLoader;
import exercise.data.MessageLoader;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductsPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static exercise.assertions.Locators.Orderplacedsuccessfully;
import static exercise.data.RandomDataGenerator.*;


public class ValidCheckoutTest extends BaseTest {
    HomePage homePage=new HomePage(page);
    ProductsPage productsPage=new ProductsPage(page);
    MessageLoader messageLoader=MessageLoader.getInstance();
    LoginPage loginPage=new LoginPage(page);
    DataLoader dataLoader=DataLoader.getInstance();
    CheckoutPage checkoutPage=new CheckoutPage(page);

    @Test
    public void successfulCheckoutWithAddingAddress(){
        homePage.clickSignButton();
        loginPage.fillOutUserCredentials(dataLoader.email(), dataLoader.password());
        homePage.shopNow();
        productsPage.selectProduct(dataLoader.productName());
        productsPage.selectProductColor();
        productsPage.addToCart();
        checkoutPage.clickBasket();
        checkoutPage.clickCheckoutButton();
        checkoutPage.AddNewAddress();
        checkoutPage.fillOutDeliveryAddress(firstName(),lastName(),phone(),street(),city(),state(),country());
        checkoutPage.SaveAddress();
        checkoutPage.clickContinueButton();
        checkoutPage.clickPay_when_your_order_arrives();
        checkoutPage.clickReviewOrder();
        checkoutPage.clickPlaceOrder();
        assertThat(Orderplacedsuccessfully()).isVisible();
        assertThat(Orderplacedsuccessfully()).containsText(messageLoader.orderPlacedSuccessfully());
    }


}
