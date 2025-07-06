import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageobject.ForgotPasswordPage;
import pageobject.HomePage;
import pageobject.LoginPage;
import pageobject.RegisterPage;
import user.usermodel.UserRegistrationModel;

import static pageobject.HomePage.HOME_PAGE_URL;

public class LoginTest extends BaseTest {
    private HomePage objHomePage;
    private RegisterPage objRegisterPage;
    private LoginPage objLoginPage;
    private ForgotPasswordPage objForgotPasswordPage;
    private String name;
    private String email;
    private String password;


    @BeforeEach
    public void setUp() {
        baseSetUp();
        objHomePage = new HomePage(driver);
        objRegisterPage = new RegisterPage(driver);
        objLoginPage = new LoginPage(driver);
        objForgotPasswordPage = new ForgotPasswordPage(driver);
        name = faker.name().fullName();
        email = faker.internet().emailAddress();
        password = generateRandomPassword(6, 6);
        UserRegistrationModel newUser = new UserRegistrationModel(email, password, name);
        Response user = userApiClient.registerNewUser(newUser);
        accessToken = userApiClient.getAccessTokenUser(user);
    }

    @Test
    @DisplayName("Вход через личный кабинет")
    public void loginFromPersonalAccountTest() {
        objHomePage.openHomePage();
        objHomePage.clickPersonalAccountButton();
        objLoginPage.fillLoginForm(email, password);
        objLoginPage.clickLoginButton();
        waitForPage(HOME_PAGE_URL);
        checkUrl(HOME_PAGE_URL);
    }
    @Test
    @DisplayName("Вход через кнопку Войти в аккаунт на домашней странице")
    public void loginFromLoginButtonOnHomePageTest() {
        objHomePage.openHomePage();
        objHomePage.clickLogInButton();
        objLoginPage.fillLoginForm(email, password);
        objLoginPage.clickLoginButton();
        waitForPage(HOME_PAGE_URL);
        checkUrl(HOME_PAGE_URL);
    }
    @Test
    @DisplayName("Вход через кнопку Войти в форме регистрации")
    public void loginFromLoginButtonOnRegisterPageTest() {
        objRegisterPage.openRegisterPage();
        objRegisterPage.clickLogInButton();
        objLoginPage.fillLoginForm(email, password);
        objLoginPage.clickLoginButton();
        waitForPage(HOME_PAGE_URL);
        checkUrl(HOME_PAGE_URL);
    }
    @Test
    @DisplayName("Вход через кнопку Войти в форме восстановления пароля")
    public void loginFromLoginButtonOnForgotPasswordPageTest() {
        objForgotPasswordPage.openForgotPasswordPage();
        objForgotPasswordPage.clickLoginButton();
        objLoginPage.fillLoginForm(email, password);
        objLoginPage.clickLoginButton();
        waitForPage(HOME_PAGE_URL);
        checkUrl(HOME_PAGE_URL);
    }
}
