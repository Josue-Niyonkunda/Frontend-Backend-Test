package exercise.tests.search;

import exercise.base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static exercise.assertions.Locators.searchLocator;

public class SearchTest extends BaseTest {
    HomePage homePage=new HomePage(page);
    @Test
    public void searchTest(){
        homePage.startShopping();
        homePage.clickSearch("bag");
        assertThat(searchLocator()).isVisible();
    }

}
