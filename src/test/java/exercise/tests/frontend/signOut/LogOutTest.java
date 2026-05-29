package exercise.tests.frontend.signOut;

import exercise.base.BaseTest;
import exercise.data.DataLoader;
import exercise.data.MessageLoader;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static exercise.assertions.Locators.logoutMsg;

public class LogOutTest extends BaseTest {
    HomePage homePage=new HomePage(page);
    LoginPage loginPage=new LoginPage(page);
    DataLoader dataLoader= DataLoader.getInstance();
    MessageLoader messageLoader= MessageLoader.getInstance();
    @Test
    public void successfulLoginOut() {
        homePage.clickSignButton();
        loginPage.fillOutUserCredentials(dataLoader.email(), dataLoader.password());
        loginPage.logOut();
        assertThat(logoutMsg())
                .containsText(messageLoader.logoutText());

    }
    }
