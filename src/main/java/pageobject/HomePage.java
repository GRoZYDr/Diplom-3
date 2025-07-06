package pageobject;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class HomePage {
    public final static String HOME_PAGE_URL = "https://stellarburgers.nomoreparties.site/";
    private final WebDriver driver;


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //Кнопка "Конструктор"
    private final By constructorButton = By.xpath(".//p[text()='Конструктор']");
    //Кнопка "Лента Заказов"
    private final By ordersListButton = By.xpath(".//p[text()='Лента Заказов']");
    //Логотип
    private final By stellarBurgersLogo = By.xpath(".//div/a");
    //Кнопка "Личный кабинет"
    private final By personalAccountButton = By.xpath(".//p[text()='Личный Кабинет']");
    //Кнопка "Войти в аккаунт"
    private final By logInButton = By.xpath(".//button[text()= 'Войти в аккаунт']");
    //Кнопка "Булки"
    private final By bunsButton = By.xpath(".//div[span[text()='Булки']]");
    //Кнопка "Булки" активна
    private final By bunsButtonActive = By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect'][.//span[text()='Булки']]");
    //Кнопка "Соусы"
    private final By saucesButton = By.xpath(".//div[span[text()='Соусы']]");
    //Кнопка "Соусы" активна
    private final By saucesButtonActive = By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect'][.//span[text()='Соусы']]");
    //Кнопка "Начинки"
    private final By fillingsButton = By.xpath(".//div[span[text()='Начинки']]");
    //Кнопка "Начинки" активна
    private final By fillingsButtonActive = By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect'][.//span[text()='Начинки']]");
    // Кнопка "Оформить заказ"
    private final By createOrderButton = By.xpath(".//button[text()='Оформить заказ']");

    public HomePage openHomePage() {
        driver.get(HOME_PAGE_URL);
        return this;
    }

    @Step("Нажатие кнопки Конструктор")
    public void clickConstructorButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(constructorButton));
        WebElement fieldName = driver.findElement(constructorButton);
        fieldName.click();
    }
    @Step("Нажатие лого Stellar Burgers")
    public void clickStellarBurgersLogo() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(constructorButton));
        WebElement fieldName = driver.findElement(constructorButton);
        fieldName.click();
    }

    @Step("Нажатие кнопки Лента Заказов")
    public void clickOrdersListButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(ordersListButton));
        WebElement button = driver.findElement(ordersListButton);
        button.click();
    }

    @Step("Нажатие кнопки Личный кабинет")
    public void clickPersonalAccountButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(personalAccountButton));
        WebElement button = driver.findElement(personalAccountButton);
        button.click();
    }

    @Step("Нажатие кнопки Войти в аккаунт")
    public void clickLogInButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(logInButton));
        WebElement button = driver.findElement(logInButton);
        button.click();
    }

    @Step("Нажатие кнопки Булки")
    public void clickBunsButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(bunsButton));
        WebElement button = driver.findElement(bunsButton);
        button.click();
    }

    @Step("Нажатие кнопки Соусы")
    public void clickSaucesButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(saucesButton));
        WebElement button = driver.findElement(saucesButton);
        button.click();
    }

    @Step("Нажатие кнопки Начинки")
    public void clickFillingsButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(fillingsButton));
        WebElement button = driver.findElement(fillingsButton);
        button.click();
    }

    @Step("Нажатие кнопки Оформить заказ")
    public void clickCreateOrderButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(createOrderButton));
        WebElement button = driver.findElement(createOrderButton);
        button.click();
    }

    @Step("Активный раздел Булки")
    public boolean checkBunsButtonActive() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(bunsButtonActive));
        return element.isDisplayed();
    }

    @Step("Активный раздел Соусы")
    public boolean checkSaucesButtonActive() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(saucesButtonActive));
        return element.isDisplayed();
    }

    @Step("Активный раздел Начинки")
    public boolean checkFillingsButtonActive() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(fillingsButtonActive));
        return element.isDisplayed();
    }


}




