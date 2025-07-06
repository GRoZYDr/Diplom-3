import browseroptions.BrowserOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import user.userapi.UserApiClient;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String accessToken;
    protected UserApiClient userApiClient;
    protected Faker faker;

    void baseSetUp() {
//        WebDriverManager.chromedriver().setup();//WebDriverManager.firefoxdriver().setup();
        driver = BrowserOptions.getWebDriver();//new ChromeDriver();//driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        faker = new Faker();
        userApiClient = new UserApiClient();
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        if (accessToken != null) {
            userApiClient.deleteUser(accessToken);
        }
    }

    @Step("Ожидание загрузки страницы {expectedUrl}")
    public void waitForPage(String expectedUrl) {
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
    }

    @Step("Проверка URL {expectedUrl}")
    public void checkUrl(String expectedUrl) {
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }

    static String generateRandomPassword(int minLength, int maxLength) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+";
        StringBuilder password = new StringBuilder();
        int length = (int) (Math.random() * (maxLength - minLength + 1)) + minLength;

        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * chars.length());
            password.append(chars.charAt(index));
        }
        return password.toString();
    }

    // Метод, предоставляющий некорректные пароли
    static Stream<String> provideInvalidPasswords() {
        return Stream.of(
                generateRandomPassword(5, 5),
                " "
        );
    }
}
