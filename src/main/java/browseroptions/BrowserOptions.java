package browseroptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserOptions {


    public static final BrowserName BROWSER_NAME = BrowserName.CHROME;


    public enum BrowserName {
        CHROME,
        YANDEX,
        FIREFOX
    }

    // Метод для получения WebDriver
    public static WebDriver getWebDriver() {
        // Получаем имя браузера из параметров командной строки
        String browserName = System.getProperty("browser", "CHROME").toUpperCase();

        switch (BrowserName.valueOf(browserName)) {
            case FIREFOX:
                // Установка WebDriver для Firefox
                WebDriverManager.firefoxdriver().setup(); // Автоматическая установка FirefoxDriver
                return new FirefoxDriver();
            case YANDEX:
                // Установка WebDriver для Yandex
                System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");
                ChromeOptions yandexOptions = new ChromeOptions();
                String userHome = System.getProperty("user.home");
                yandexOptions.setBinary(userHome + "\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe"); // Путь к исполняемому файлу Yandex
                return new ChromeDriver(yandexOptions);
            default:
                // Установка WebDriver для Chrome
                WebDriverManager.chromedriver().setup(); // Автоматическая установка ChromeDriver
                return new ChromeDriver();
        }
    }
}
// Метод для получения WebDriver
//    public static WebDriver getWebDriver() {
//        String browserName = System.getProperty("browser");
//        switch (browserName) {
//            case "firefox":
//                return new FirefoxDriver();
//            case "yandex":
//                System.setProperty("webdriver.chrome.driver", "src/test/resources/yandexdriver");
//                ChromeOptions options = new ChromeOptions();
//                options.setBinary("C:\\Users\\777\\AppData\\Local\\Yandex\\YandexBrowser\\Application");
//                return new ChromeDriver(options);
//            default:
//                return new ChromeDriver();
//        }
//    }
//}
