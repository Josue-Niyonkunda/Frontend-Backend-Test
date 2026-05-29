package exercise.tests.frontend.login;




import exercise.base.BaseTest;
import exercise.data.DataLoader;
import exercise.data.MessageLoader;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.HomePage;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static exercise.assertions.Locators.accountCreationMsg;

public class ValidLoginTest extends BaseTest {


    HomePage homePage=new HomePage(page);
    LoginPage loginPage=new LoginPage(page);
    DataLoader dataLoader= DataLoader.getInstance();
    MessageLoader messageLoader= MessageLoader.getInstance();
    @Test
    public void successfulLogin(){
    homePage.clickSignButton();
    loginPage.fillOutUserCredentials(dataLoader.email(), dataLoader.password());
        assertThat(accountCreationMsg()).isVisible();
        assertThat(accountCreationMsg())
                .containsText(messageLoader.successfulLoginMsg());

    }
}