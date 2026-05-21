package pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class ProductsPage {
    private final ThreadLocal<Page> page;
    public ProductsPage(ThreadLocal<Page> page) {
        this.page = page;
    }
    public void selectProduct(){

        page.get().getByText("Clear PVC Stadium Tote Bag").click();

    }
    public void selectProductColor(){
        page.get().locator("button[title='Brown']").click();

    }
    public void addToCart(){


        page.get().getByRole(AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName("Add to Cart")
        ).click();

    }

}
