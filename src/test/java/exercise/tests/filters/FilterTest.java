package exercise.tests.filters;

import exercise.assertions.Locators;
import exercise.base.BaseTest;
import exercise.data.DataLoader;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductsPage;

import java.util.Arrays;
import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static exercise.assertions.Locators.*;

public class FilterTest extends BaseTest {
    HomePage homePage=new HomePage(page);
    ProductsPage productsPage=new ProductsPage(page);
    DataLoader dataLoader=DataLoader.getInstance();
    @Test
    public void filterByCategoryTest(){
        homePage.startShopping();
        homePage.clickShop();
        productsPage.selectCategories(dataLoader.categoryName());
        assertThat(categoryTitleLocator(dataLoader.categoryName())).isVisible();
    }
    @Test
    public void filterByPriceTest() {

        homePage.startShopping();
        homePage.clickShop();

        productsPage.selectCategories(dataLoader.categoryName());
        assertThat(categoryTitleLocator(dataLoader.categoryName())).isVisible();
        productsPage.selectPriceRange(
                dataLoader.min(),
                dataLoader.max()
        );

        page.get().waitForLoadState();
        double minPrice = Double.parseDouble(dataLoader.min());
        double maxPrice = Double.parseDouble(dataLoader.max());
        List<String> prices = productPrices();
        System.out.println(Arrays.toString(prices.toArray()));
        for (String priceText : prices) {
            double price = Double.parseDouble(
                    priceText.replace("$", ""));
            Assert.assertTrue(
                    price >= minPrice && price <= maxPrice,
                    "Price out of range: " + price
            );
        }
    }


    @Test
    public void filterBySizeTest(){
        homePage.startShopping();
        homePage.clickShop();
        productsPage.selectBySize(dataLoader.size());
        assertThat(sizeLocator()).isVisible();
    }
}
