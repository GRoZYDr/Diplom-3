package pageobject;

import org.openqa.selenium.*;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {
    public final static String REGISTER_PAGE_URL = "https://stellarburgers.nomoreparties.site/register";
    private final WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    //Поле "Имя"
    private final By nameField = By.xpath("//label[text()='Имя']/following-sibling::input");
    //Поле "Email"
    private final By emailField = By.xpath("//label[text()='Email']/following-sibling::input");
    //Поле "Пароль"
    private final By passwordField = By.xpath("//label[text()='Пароль']/following-sibling::input");
    //Кнопка "Зарегистрироваться"
    private final By registerButton = By.xpath("//button[text()='Зарегистрироваться']");
    //Сообщение валидации "Некорректный пароль"
    private final By invalidPasswordMessage = By.xpath("//p[text()='Некорректный пароль']");
    //Кнопка "Войти"
    private final By logInButton = By.xpath("//a[text()='Войти']");

    public RegisterPage openRegisterPage() {
        driver.get(REGISTER_PAGE_URL);
        return this;
    }

    @Step("Заполнение формы регистрации")
    public void fillRegistrationForm(String name, String email, String password) {
        fillName(name);
        fillEmail(email);
        fillPassword(password);
    }

    @Step("Заполнение поля Имя")
    public void fillName(String name) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(nameField));
        WebElement fieldName = driver.findElement(nameField);
        fieldName.click();
        fieldName.clear();
        fieldName.sendKeys(name);
    }

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

    @Step("Нажатие кнопки Зарегистрироваться")
    public void clickRegisterButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(registerButton));
        WebElement fieldName = driver.findElement(registerButton);
        fieldName.click();
    }

    @Step("Нажатие кнопки Войти")
    public void clickLogInButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(logInButton));
        WebElement fieldName = driver.findElement(logInButton);
        fieldName.click();
    }

    @Step("Сообщение валидации \"Некорректный пароль\"")
    public boolean invalidPasswordMessageIsDisplayed() {
        try {
            // Ожидаем, пока элемент станет видимым
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.visibilityOfElementLocated(invalidPasswordMessage));

            // Получаем элемент и проверяем, отображается ли он
            WebElement messageElement = driver.findElement(invalidPasswordMessage);
            return messageElement.isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            // Если элемент не найден или не виден, возвращаем false
            return false;
        }
    }

    @Step("Получения токена")
    public String getToken() {
        return (String) ((JavascriptExecutor) driver).executeScript("return localStorage.getItem('accessToken');");
    }
}

