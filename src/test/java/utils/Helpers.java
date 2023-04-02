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
    public static List<WebElement> searchCustomer(String searchString, String name, String last, String postalCode, MainPage mainPage, WebDriver driver, WebDriverWait wait) {
        creatingCustomer(name, last, postalCode, mainPage, driver, wait);
        mainPage.clickButtonCustomer();
        Waiters.waitVisibilityElement(mainPage.searchCustomerInput, wait);
        mainPage.searchCustomer(searchString);
        List<WebElement> table = mainPage.rowsFromTableCustomer;
        return table;
    }

    @Step("Проверка все ли элементы списка содержат {searchString}")
    public static boolean isContainsSearchString(String searchString, String name, String lastName, String postalCode, MainPage mainPage, WebDriver driver, WebDriverWait wait) {
        List<WebElement> table = searchCustomer(searchString, name, lastName, postalCode, mainPage, driver, wait);
        //если лист пустой, то тест не пройдет
        boolean cellHaveFirstName = false;
        for (WebElement element : table) {
            String row = element.getText();
            cellHaveFirstName = row.contains(searchString);
            if (!cellHaveFirstName) break;
        }
        return cellHaveFirstName;
    }
}
