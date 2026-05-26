package exercise.tests.end2end;


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
import static exercise.assertions.Locators.categoryTitleLocator;
import static exercise.data.RandomDataGenerator.*;

public class EndToEndTest extends BaseTest {
    HomePage homePage=new HomePage(page);
    ProductsPage productsPage=new ProductsPage(page);
    LoginPage loginPage=new LoginPage(page);
    CheckoutPage checkoutPage=new CheckoutPage(page);
    DataLoader dataLoader=DataLoader.getInstance();
    MessageLoader messageLoader=MessageLoader.getInstance();
    @Test
    public void end2end(){
        homePage.startShopping();
        homePage.clickSignButton();
        loginPage.fillOutUserCredentials(dataLoader.email(), dataLoader.password());
        homePage.shopNow();

        productsPage.selectCategories(dataLoader.categoryName());
        assertThat(categoryTitleLocator(dataLoader.categoryName())).isVisible();
        productsPage.selectPriceRange(
                dataLoader.min(),
                dataLoader.max()
        );
        productsPage.selectProduct(dataLoader.productName());
        productsPage.selectProductColor();
        productsPage.addToCart();

        page.get().waitForLoadState();
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
