package exercise.tests.frontend.addToCart;

import exercise.base.BaseTest;
import exercise.data.DataLoader;
import exercise.data.MessageLoader;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductsPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static exercise.assertions.Locators.productsAddedToCart;


public class AddToCartTest extends BaseTest {
    @Test
    public void successfulAddToCart(){
   HomePage homePage=new HomePage(page);
        ProductsPage productsPage=new ProductsPage(page);
        MessageLoader messageLoader=MessageLoader.getInstance();
        DataLoader dataLoader=DataLoader.getInstance();
   homePage.startShopping();
        homePage.shopNow();
        productsPage.selectProduct(dataLoader.productName());
        productsPage.selectProductColor();
       productsPage.addToCart();
       assertThat(productsAddedToCart()).hasText(messageLoader.productsAddedToTheCart());


    }
}
