package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {

    public final static String PROFILE_PAGE_URL = "https://stellarburgers.nomoreparties.site/account/profile";
    private final WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public ProfilePage openProfilePage() {
        driver.get(PROFILE_PAGE_URL);
        return this;
    }

    //Кнопка "Выход"
    private final By exitButton = By.xpath(".//button[text()='Выход']");

    @Step("Нажатие кнопки Выход")
    public void clickExitButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(exitButton));
        WebElement fieldName = driver.findElement(exitButton);
        fieldName.click();
    }
}
