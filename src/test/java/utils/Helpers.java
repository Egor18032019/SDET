package utils;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPage;

import java.util.List;

public class Helpers {
    @Step("Создание нового клиента +  accept модального окна")
    public static void creatingCustomer(String name, String last, String postalCode, MainPage page, WebDriver driver, WebDriverWait wait) {
        page.creatNewCustomer(name, last, postalCode);
        Waiters.waitAlertWindow(wait);
        Alert alert = driver.switchTo().alert();
        String textOnAlert = alert.getText();
        boolean iaAdded = textOnAlert.startsWith(Const.expectedTextAfterCreatNewCustomer);
        Assertions.assertTrue(iaAdded, "New customer not added");
        alert.accept();
    }

    public static boolean searchCustomer(String searchString, String name, String last, String postalCode, MainPage mainPage, WebDriver driver, WebDriverWait wait) {
        creatingCustomer(name, last, postalCode, mainPage, driver, wait);
        mainPage.searchCustomer(searchString);
        List<WebElement> table = mainPage.rowsFromTableCustomer;
        //если лист пустой, то тест не пройдет
        boolean cellHaveFirstName = false;
        for (WebElement element : table) {
            String row = element.getText().split(" ")[0];
            cellHaveFirstName = row.contains(Const.firstName);
            if (!cellHaveFirstName) break;
        }
        return cellHaveFirstName;
    }

}
