package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class ProductsPage {
    private final ThreadLocal<Page> page;
    public ProductsPage(ThreadLocal<Page> page) {
        this.page = page;
    }
    public void selectProduct(String productName){

        page.get().getByText(productName).click();

    }
    public void selectProductColor(){
        page.get().locator("button[title='Brown']").click();

    }
    public void addToCart(){


        page.get().getByRole(AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName("Add to Cart")
        ).click();

    }
    public void clickOnLikingIcon(){
        page.get().locator("button[class='w-14 h-14 rounded-xl border-2 flex items-center justify-center transition-all duration-200 border-brand-border text-brand-text hover:border-brand-red hover:text-brand-red']").click();

    }
    public void selectCategories(String category){
        Locator cat = page.get().locator(".space-y-1", new Page.LocatorOptions().setHasText(category)).nth(1);
        page.get().waitForTimeout(1500);
        cat.waitFor();
    }
    public void selectPriceRange(String min,String max){
        page.get().locator("[placeholder='Min']").fill(min);
       page.get().locator("[placeholder='Max']").fill(max);
    }
    public void selectBySize(String size){
        page.get().getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName(size)).click();
    }

}
