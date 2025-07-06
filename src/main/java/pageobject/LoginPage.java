package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginPage {
    public final static String LOGIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/login";
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage openLoginPage() {
        driver.get(LOGIN_PAGE_URL);
        return this;
    }

    private final By emailField = By.xpath("//input[@name='name']");
    private final By passwordField = By.xpath("//input[@name='Пароль']");
    private final By loginButton = By.xpath("//button[text()='Войти']");

    @Step("Заполнение поля Email")
    public void fillEmail(String email) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(emailField));
        WebElement fieldName = driver.findElement(emailField);
        fieldName.click();
        fieldName.clear();
        fieldName.sendKeys(email);
    }

    @Step("Заполнение поля Пароль")
    public void fillPassword(String password) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        WebElement fieldName = driver.findElement(passwordField);
        fieldName.click();
        fieldName.clear();
        fieldName.sendKeys(password);
    }
    @Step("Заполнение формы входа")
    public void fillLoginForm(String email, String password){
        fillEmail(email);
        fillPassword(password);
    }

    @Step("Нажатие кнопки Войти")
    public void clickLoginButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        WebElement fieldName = driver.findElement(loginButton);
        fieldName.click();
    }

}