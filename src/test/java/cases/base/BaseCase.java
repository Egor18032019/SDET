package cases.base;

import java.time.Duration;

import utils.Const;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseCase {

    public static WebDriver driver;

    // TODO проверить интернет
    @BeforeEach
    public void openURL() {
        System.out.println("open");
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdriver/chromedriver.exe");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(11));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(22));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(33));
        driver.navigate().to(Const.urlMain);
    }

    @AfterEach()
    public void closeBrowser() {
        System.out.println("close");
        driver.quit();
    }


}
