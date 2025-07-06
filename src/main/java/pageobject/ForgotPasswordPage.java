package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ForgotPasswordPage {

    public final static String FP_PAGE_URL = "https://stellarburgers.nomoreparties.site/forgot-password";
    private final WebDriver driver;

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public ForgotPasswordPage openForgotPasswordPage() {
        driver.get(FP_PAGE_URL);
        return this;
    }

    //Кнопка "Войти"
    private final By loginButton = By.xpath(".//a[text()='Войти']");

    @Step("Нажатие кнопки Войти")
    public void clickLoginButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        WebElement fieldName = driver.findElement(loginButton);
        fieldName.click();
    }
}
