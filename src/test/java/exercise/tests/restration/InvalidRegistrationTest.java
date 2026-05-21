package exercise.tests.restration;


import com.microsoft.playwright.Locator;
import exercise.base.BaseTest;
import exercise.data.DataLoader;
import exercise.data.MessageLoader;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.HomePage;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static exercise.assertions.Locators.*;
import static exercise.data.RandomDataGenerator.*;
import static exercise.data.RandomDataGenerator.password;

public class InvalidRegistrationTest extends BaseTest {
    HomePage homePage=new HomePage(page);
    AccountPage accountPage=new AccountPage(page);
    DataLoader dataLoader= DataLoader.getInstance();
    MessageLoader messageLoader= MessageLoader.getInstance();
    @Test
    public void registerWithRegisteredEmail(){

        homePage.clickCreateAccount();
        accountPage.enterCredentials(firstName(),lastName(),dataLoader.email(),password());
        accountPage.clickCreateAccountButton();

        assertThat(accountCreationMsg()).isVisible();
        assertThat(accountCreationMsg())
                .containsText(messageLoader.emailAlreadyCreated());

    }

}
