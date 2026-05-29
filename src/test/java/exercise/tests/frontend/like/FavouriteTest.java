package exercise.tests.frontend.like;

import exercise.base.BaseTest;
import exercise.data.DataLoader;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductsPage;

import javax.xml.crypto.Data;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static exercise.assertions.Locators.getWishlist;

public class FavouriteTest extends BaseTest {
    HomePage homePage=new HomePage(page);
    LoginPage loginPage=new LoginPage(page);
    ProductsPage productsPage=new ProductsPage(page);
    DataLoader dataLoader=DataLoader.getInstance();
    @Test
    public void likingTest(){
       homePage.startShopping();
       homePage.clickSignButton();
        loginPage.fillOutUserCredentials(dataLoader.email(), dataLoader.password());
        homePage.clickShop();
        productsPage.selectProduct(dataLoader.productName());
        productsPage.clickOnLikingIcon();
        assertThat(getWishlist()).hasText(dataLoader.wishListItem());


    }
    
}
