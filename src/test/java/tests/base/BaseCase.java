package tests.base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.Const;

import java.time.Duration;

public class BaseCase {

    public static WebDriver driver;

    // TODO проверить интернет
    @BeforeEach
    public void openURL() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        System.setProperty("webdriver.chrome.driver",  Const.pathGoogleDriver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(11));
        driver.navigate().to(Const.urlMain);
    }

    @AfterEach()
    public void closeBrowser() {
        driver.quit();
    }


}
