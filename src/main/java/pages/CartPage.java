package pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class CartPage {
    private final ThreadLocal <Page> page;

    public CartPage(ThreadLocal <Page> page){

        this.page = page;
    }


}