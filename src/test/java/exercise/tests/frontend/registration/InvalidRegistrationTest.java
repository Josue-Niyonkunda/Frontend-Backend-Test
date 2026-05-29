package exercise.tests.frontend.registration;


import exercise.base.BaseTest;
import exercise.data.DataLoader;
import exercise.data.MessageLoader;
import org.testng.annotations.Test;
import pages.RegisterPage;
import pages.HomePage;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static exercise.assertions.Locators.*;
import static exercise.data.RandomDataGenerator.*;
import static exercise.data.RandomDataGenerator.password;

public class InvalidRegistrationTest extends BaseTest {
    HomePage homePage=new HomePage(page);
    RegisterPage registerPage =new RegisterPage(page);
    DataLoader dataLoader= DataLoader.getInstance();
    MessageLoader messageLoader= MessageLoader.getInstance();
    @Test
    public void registerWithRegisteredEmail(){

        homePage.clickCreateAccount();
        registerPage.enterCredentials(firstName(),lastName(),dataLoader.email(),password());
        registerPage.clickCreateAccountButton();

        assertThat(accountCreationMsg()).isVisible();
        assertThat(accountCreationMsg())
                .containsText(messageLoader.emailAlreadyCreated());

    }

}
