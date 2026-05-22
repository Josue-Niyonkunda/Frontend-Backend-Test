package exercise.tests.login;



import exercise.base.BaseTest;
import exercise.data.DataLoader;
import exercise.data.MessageLoader;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;


import static exercise.assertions.Locators.*;

public class InvalidLoginTest extends BaseTest {
    HomePage homePage=new HomePage(page);
    LoginPage loginPage=new LoginPage(page);
    DataLoader dataLoader= DataLoader.getInstance();
    MessageLoader messageLoader= MessageLoader.getInstance();

    @Test
    public void loginWithEmptyEmail(){
        homePage.clickSignButton();
        loginPage.fillOutUserCredentials("", dataLoader.password());
               assert emptyEmailValidation().equals(messageLoader.emptyFieldsValidation());

    }

    @Test
    public void loginWithEmptyPassword(){
        homePage.clickSignButton();
        loginPage.fillOutUserCredentials(dataLoader.email(), "");
        assert emptyPasswordValidation().equals(messageLoader.emptyFieldsValidation());



    }




}
