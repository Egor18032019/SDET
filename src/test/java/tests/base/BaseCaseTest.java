package tests.base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Const;

import java.time.Duration;

public class BaseCaseTest {
    public static WebDriver driver;
    public static WebDriverWait wait;

    // TODO проверить интернет
    @BeforeEach
    public void openURL() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
//        System.setProperty("webdriver.chrome.driver", Const.pathGoogleDriver);
        driver.manage().window().maximize();
        driver.navigate().to(Const.urlMain);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterEach()
    public void closeBrowser() {
        driver.quit();
    }
}
