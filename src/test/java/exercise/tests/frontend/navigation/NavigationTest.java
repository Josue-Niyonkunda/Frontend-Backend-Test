package exercise.tests.frontend.navigation;

import exercise.base.BaseTest;
import exercise.data.MessageLoader;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static exercise.assertions.Locators.*;

public class NavigationTest extends BaseTest {
    HomePage homePage=new HomePage(page);
    MessageLoader messageLoader=MessageLoader.getInstance();
    @BeforeMethod
    public void navigateToHomePage(){
        homePage.startShopping();
    }
    @Test
    public void navigateToHome(){
        homePage.clickHome();
        assertThat(homeValidation()).hasText(messageLoader.home());
    }
    @Test
    public void navigateToFeatured(){
        homePage.clickFeatured();
        assertThat(featuredValidation()).containsText(messageLoader.featured());
    }
    @Test
    public void navigateToShop(){
        homePage.clickShop();
        assertThat(ShopValidation()).containsText(messageLoader.shop());
    }
    @Test
    public void navigateToFlashProducts(){
        homePage.clickFlash();
        assertThat(flashValidation()).containsText(messageLoader.flash());
    }

}
