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





}
