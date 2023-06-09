package tests.base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.parallel.Execution;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Const;
import utils.Helpers;

import java.time.Duration;

import static org.junit.jupiter.api.parallel.ExecutionMode.CONCURRENT;

/**
 * Родительский класс в котором прописано открытие браузера и закрытие браузера
 * + инициализация WebDriver и WebDriverWait
 */
@Execution(CONCURRENT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
 public class BaseCaseTest {
    public   WebDriver driver;
    public   WebDriverWait wait;

    @BeforeEach
    public void openURL() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        if (Helpers.isWindows()) {
            System.setProperty("webdriver.chrome.driver", Const.pathGoogleDriver);
        }
        driver.manage().window().maximize();
        driver.navigate().to(Const.urlMain);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @AfterEach()
    public void closeBrowser() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
