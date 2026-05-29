package exercise.tests.frontend.search;

import exercise.base.BaseTest;
import exercise.data.DataLoader;
import org.testng.annotations.Test;
import pages.HomePage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static exercise.assertions.Locators.searchLocator;

public class SearchTest extends BaseTest {
    HomePage homePage=new HomePage(page);
    DataLoader dataLoader=DataLoader.getInstance();
    @Test
    public void searchTest(){
        homePage.startShopping();
        homePage.clickSearch(dataLoader.searchProduct());
        assertThat(searchLocator(dataLoader.searchProduct())).isVisible();
    }


}
