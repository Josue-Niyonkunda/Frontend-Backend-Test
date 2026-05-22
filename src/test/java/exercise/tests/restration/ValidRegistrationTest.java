package exercise.tests.restration;




import exercise.base.BaseTest;

import exercise.data.MessageLoader;
import org.testng.annotations.Test;
import pages.RegisterPage;
import pages.HomePage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import static exercise.assertions.Locators.accountCreationMsg;
import static exercise.data.RandomDataGenerator.*;

public class ValidRegistrationTest extends BaseTest {
    @Test
public void registerUser(){

        HomePage homePage=new HomePage(page);
        RegisterPage registerPage =new RegisterPage(page);
        MessageLoader msg=MessageLoader.getInstance();
        homePage.clickCreateAccount();
        registerPage.enterCredentials(firstName(),lastName(),email(),password());
        registerPage.clickCreateAccountButton();

      assertThat(accountCreationMsg()).hasText(msg.accountCreatedSuccessful());

    }
}
