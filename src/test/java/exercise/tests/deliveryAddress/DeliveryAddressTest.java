package exercise.tests.deliveryAddress;

import exercise.base.BaseTest;
import exercise.data.DataLoader;
import exercise.data.MessageLoader;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductsPage;


import static exercise.assertions.Locators.emptyFirstnameValidation;
import static exercise.data.RandomDataGenerator.*;
import static exercise.data.RandomDataGenerator.city;
import static exercise.data.RandomDataGenerator.country;
import static exercise.data.RandomDataGenerator.state;
import static exercise.data.RandomDataGenerator.street;

public class DeliveryAddressTest extends BaseTest {
    HomePage homePage=new HomePage(page);
    ProductsPage productsPage=new ProductsPage(page);
    MessageLoader messageLoader=MessageLoader.getInstance();
    LoginPage loginPage=new LoginPage(page);
    DataLoader dataLoader=DataLoader.getInstance();
    CheckoutPage checkoutPage=new CheckoutPage(page);
    @BeforeMethod
    public void beforeMethod(){
        homePage.clickSignButton();
        loginPage.fillOutUserCredentials(dataLoader.email(), dataLoader.password());
        homePage.shopNow();
        productsPage.selectProduct(dataLoader.productName());
        productsPage.selectProductColor();
        productsPage.addToCart();
        checkoutPage.clickBasket();
        checkoutPage.clickCheckoutButton();
        checkoutPage.AddNewAddress();
    }

    @Test
    public void successfulAddingAddress() {

        checkoutPage.fillOutDeliveryAddress(firstName(),lastName(),phone(),street(),city(),state(),country());
        checkoutPage.SaveAddress();
    }
    @Test
    public void AddingAddressWithRequiredFirstnameFieldValidation() {
        checkoutPage.fillOutDeliveryAddress("",lastName(),phone(),street(),city(),state(),country());
        checkoutPage.SaveAddress();
        assert emptyFirstnameValidation().equals(messageLoader.emptyFieldsValidation());
    }


}
