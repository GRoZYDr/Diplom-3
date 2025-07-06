import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import pageobject.*;
import user.usermodel.UserRegistrationModel;

import static pageobject.HomePage.HOME_PAGE_URL;
import static pageobject.LoginPage.LOGIN_PAGE_URL;
import static pageobject.ProfilePage.PROFILE_PAGE_URL;

public class PersonalAccountTest extends BaseTest {
    private HomePage objHomePage;
    private ProfilePage objProfilePage;
    private String name;
    private String email;
    private String password;
    private String refreshToken;

    @BeforeEach
    public void setUp() {
        baseSetUp();
        objHomePage = new HomePage(driver);
        objProfilePage = new ProfilePage(driver);
        name = faker.name().fullName();
        email = faker.internet().emailAddress();
        password = generateRandomPassword(6, 6);
        UserRegistrationModel newUser = new UserRegistrationModel(email, password, name);
        Response user = userApiClient.registerNewUser(newUser);
        accessToken = userApiClient.getAccessTokenUser(user);
        refreshToken = userApiClient.getRefreshTokenUser(user);
        objHomePage.openHomePage();
        String script = "window.localStorage.setItem('accessToken', '" + "Bearer " + accessToken + "');";
        ((JavascriptExecutor) driver).executeScript(script);
    }

    @Test
    @DisplayName("Переход в личный кабинет с главной страницы через кнопку Личный кабинет")
    public void transitionFromHomePageToPersonalAccountTest() {
        objHomePage.clickPersonalAccountButton();
        waitForPage(PROFILE_PAGE_URL);
        checkUrl(PROFILE_PAGE_URL);
    }

    @Test
    @DisplayName("Переход из личного кабинета на главную страницу через кнопку Конструктор")
    public void transitionFromPersonalAccountToHomePageThroughConstructorButtonTest() {
        objHomePage.clickPersonalAccountButton();
        waitForPage(PROFILE_PAGE_URL);
        checkUrl(PROFILE_PAGE_URL);
        objHomePage.clickConstructorButton();
        waitForPage(HOME_PAGE_URL);
        checkUrl(HOME_PAGE_URL);
    }
    @Test
    @DisplayName("Переход из личного кабинета на главную страницу через лого Stellar Burgers")
    public void transitionFromPersonalAccountToHomePageThroughStellarBurgersLogoTest() {
        objHomePage.clickPersonalAccountButton();
        waitForPage(PROFILE_PAGE_URL);
        checkUrl(PROFILE_PAGE_URL);
        objHomePage.clickStellarBurgersLogo();
        waitForPage(HOME_PAGE_URL);
        checkUrl(HOME_PAGE_URL);
    }
    @Test
    @DisplayName("Выход по кнопке «Выйти» в личном кабинете")
    public void logoutFromPersonalAccountTest() {
        String script = "window.localStorage.setItem('refreshToken', '" + refreshToken + "');";
        ((JavascriptExecutor) driver).executeScript(script);
        objHomePage.clickPersonalAccountButton();
        waitForPage(PROFILE_PAGE_URL);
        checkUrl(PROFILE_PAGE_URL);
        objProfilePage.clickExitButton();
        waitForPage(LOGIN_PAGE_URL);
        checkUrl(LOGIN_PAGE_URL);
    }
}
