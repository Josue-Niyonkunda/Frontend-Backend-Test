package pages;

import com.microsoft.playwright.Page;

public class AccountPage {
    private final ThreadLocal<Page> page;
    public AccountPage(ThreadLocal<Page> page) {
        this.page = page;
    }
public void enterCredentials( String firstName,String lastName,String emailAddress, String password){
        page.get().locator("[placeholder='John']").fill(firstName);
        page.get().locator("[placeholder='Doe']").fill(lastName);
        page.get().locator("[placeholder='you@example.com']").fill(emailAddress);
        page.get().locator("[placeholder='Min. 8 characters']").fill(password);
}
public  void clickCreateAccountButton(){
    page.get().locator(".btn-primary.w-full.py-4.flex.items-center.justify-center.gap-2.mt-2").click();
}


}
