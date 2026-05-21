package exercise.base;

import com.microsoft.playwright.*;
import exercise.utils.ConfigLoader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected static ThreadLocal<Playwright> playwright = new ThreadLocal<>();
    protected static ThreadLocal<Browser> browser = new ThreadLocal<>();
    protected static ThreadLocal<BrowserContext> context = new ThreadLocal<>();
    public static ThreadLocal<Page> page = new ThreadLocal<>();

    @BeforeMethod
    public void setUp() {
        playwright.set(Playwright.create());

        browser.set(
                playwright.get().chromium().launch(
                        new BrowserType.LaunchOptions().setHeadless(false)
                )
        );

        context.set(browser.get().newContext());
        page.set(context.get().newPage());

        page.get().navigate(ConfigLoader.getInstance().getBaseUrl());
    }

    @AfterMethod
    public void tearDown() {
        page.get().close();
        context.get().close();
        browser.get().close();
        playwright.get().close();
    }

    public static Page getPage() {
        return page.get();
    }

}