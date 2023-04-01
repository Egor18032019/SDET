package utils;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import pages.MainPage;
import tests.base.BaseCaseTest;

public class Helpers {
    @Step("Создание нового клиента + +accept модального окна")
    public static void addCustomer(String name, String last, String postalCode, MainPage page, WebDriver driver) {
        page.creatNewCustomer(name, last, postalCode);
        Waiters.waitAlertWindow(BaseCaseTest.wait);
        Alert alert = driver.switchTo().alert();
        String textOnAlert =alert.getText();
        boolean iaAdded = textOnAlert.startsWith(Const.expectedTextAfterCreatNewCustomer);
        Assertions.assertTrue(iaAdded, "New customer not added");
        alert.accept();
    }
}
