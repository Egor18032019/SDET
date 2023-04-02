package utils;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AddCustomer;
import pages.Customers;

import java.util.List;

public class Helpers {
    @Step("Создание нового клиента +  accept модального окна")
    public static void creatingCustomer(String name, String last, String postalCode, AddCustomer page, WebDriver driver, WebDriverWait wait) {
        Waiters.waitVisibilityElement(page.firstNameInput, wait);
        Waiters.waitVisibilityElement(page.lastNameInput, wait);
        Waiters.waitVisibilityElement(page.postalCodeInput, wait);
        page.creatNewCustomer(name, last, postalCode);
        Waiters.WaitingModalWindow(wait);
        Alert alert = driver.switchTo().alert();
        String textOnAlert = alert.getText();
        boolean iaAdded = textOnAlert.startsWith(Const.expectedTextAfterCreatNewCustomer);
        Assertions.assertTrue(iaAdded, "New customer not added");
        alert.accept();
    }

    @Step("Поиск клиентов содержащих в ФИО {searchString}")
    public static List<WebElement> searchCustomer(String searchString, Customers customersPage, WebDriverWait wait) {
        Waiters.waitVisibilityElement(customersPage.searchCustomerInput, wait);
        customersPage.searchCustomer(searchString);
        return customersPage.rowsFromTableCustomer;
    }

    @Step("Проверка все ли элементы списка содержат {searchString}")
    public static boolean isContainsSearchString(String searchString, List<WebElement> listRows) {
        //если лист пустой, то тест не пройдет
        boolean cellHaveFirstName = false;
        for (WebElement element : listRows) {
            String row = element.getText();
            cellHaveFirstName = row.contains(searchString);
            if (!cellHaveFirstName) break;
        }
        return cellHaveFirstName;
    }
}
