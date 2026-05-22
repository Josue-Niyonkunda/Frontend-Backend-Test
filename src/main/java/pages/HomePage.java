package pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class HomePage {
    private final ThreadLocal<Page> page;
    public HomePage(ThreadLocal<Page> page) {
        this.page = page;
    }
    public void startShopping(){
        page.get().getByRole(AriaRole.LINK,
                new Page.GetByRoleOptions().setName("Start Shopping")
        ).click();
    }

    public  void shopNow(){
        page.get().getByRole(AriaRole.LINK,
                new Page.GetByRoleOptions().setName("Shop Now")
        ).first().click();
    }
    public void clickCreateAccount(){
        page.get().getByText("Create account — free").click();
    }
    public void clickSignButton(){
        page.get().getByText("Sign in").click();
    }
    public void clickHome(){
        page.get().getByRole(AriaRole.LINK,
                new Page.GetByRoleOptions().setName("Home")
        ).first().click();


    }
    public void clickFeatured(){
        page.get().getByRole(AriaRole.LINK,
                new Page.GetByRoleOptions().setName("Featured")
        ).first().click();


    }
    public void clickShop(){
        page.get().getByRole(AriaRole.LINK,
                new Page.GetByRoleOptions().setName("Shop")
        ).first().click();

    }
    public void clickFlash(){
        page.get().getByRole(AriaRole.LINK,
                new Page.GetByRoleOptions().setName("Flash")
        ).first().click();

    }

}
