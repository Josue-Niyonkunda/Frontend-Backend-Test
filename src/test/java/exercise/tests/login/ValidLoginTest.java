package exercise.tests.login;


import exercise.base.BaseTest;
import exercise.data.DataLoader;
import exercise.data.MessageLoader;
import pages.LoginPage;
import org.testng.annotations.Test;


import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static exercise.assertions.Locators.successfulMsgLocator;

public class ValidLoginTest extends BaseTest {
    @Test
    public static void login(){
        LoginPage login = new LoginPage(page);
        MessageLoader msg=MessageLoader.getInstance();
        DataLoader dataLoader=DataLoader.getInstance();
        login.login(dataLoader.getUserName(), dataLoader.getPassword());

        assertThat(successfulMsgLocator())
                .hasText(msg.successfulLoginMessage());
    }
}
