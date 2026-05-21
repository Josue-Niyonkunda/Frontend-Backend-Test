package pages;

import com.microsoft.playwright.Page;

import javax.swing.plaf.TableHeaderUI;

public class LoginPage {
    private final ThreadLocal<Page> page;
    public LoginPage(ThreadLocal<Page> page) {
        this.page = page;
    }
    public void fillOutUserCredentials(String email,String password){
        page.get().locator("[type='email']").fill(email);
        page.get().locator("[type='password']").fill(password);
        page.get().locator("[type='submit']").click();

    }


}
