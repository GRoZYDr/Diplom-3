import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pageobject.RegisterPage;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static pageobject.LoginPage.LOGIN_PAGE_URL;

public class RegisterTest extends BaseTest {

    private RegisterPage objRegisterPage;
    private String name;
    private String email;


    @BeforeEach
    public void setUp() {
        baseSetUp();
        objRegisterPage = new RegisterPage(driver);
        objRegisterPage.openRegisterPage();
        name = faker.name().fullName();
        email = faker.internet().emailAddress();

    }

    @Test
    @DisplayName("Проверка регистрации при заполнении формы валидными данными")
    public void registrationValidTest() {
        String password = generateRandomPassword(6, 6);
        objRegisterPage.fillRegistrationForm(name, email, password);
        objRegisterPage.clickRegisterButton();
        waitForPage(LOGIN_PAGE_URL);
        checkUrl(LOGIN_PAGE_URL);
        accessToken = objRegisterPage.getToken();
    }

    @ParameterizedTest
    @MethodSource("provideInvalidPasswords")
    @DisplayName("Проверка регистрации при заполнении формы с некорректными данными")
    public void registrationInvalidTest(String password) {
        objRegisterPage.fillRegistrationForm(name, email, password);
        objRegisterPage.clickRegisterButton();
        assertTrue(objRegisterPage.invalidPasswordMessageIsDisplayed());
    }
}
