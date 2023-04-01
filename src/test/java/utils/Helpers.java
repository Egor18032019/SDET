package utils;

import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import pages.MainPage;
import tests.base.BaseCaseTest;

public class Helpers {
    @Step("Создание нового клиента + accept модального окна")
    public static void addCostumer(String name, String last, String postalCode, MainPage page, WebDriver driver) {
        page.creatNewCustomer(name, last, postalCode);
        Waiters.waitAlertWindow(BaseCaseTest.wait);
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}
