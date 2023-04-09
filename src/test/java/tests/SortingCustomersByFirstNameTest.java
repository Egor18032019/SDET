package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ResourceLock;
import org.openqa.selenium.WebElement;
import pages.Customers;
import pages.MainPage;
import tests.base.BaseCaseTest;
import utils.Waiters;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.parallel.ExecutionMode.CONCURRENT;

/**
 * Тест кейс T2
 * Сортировка клиентов по имени (First Name)
 */
@Execution(CONCURRENT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
 public class SortingCustomersByFirstNameTest extends BaseCaseTest {
    MainPage mainPage;
    Customers customersPage;

    @Test
    @Issue("T2")
    @Description("Сортировка клиентов по имени (First Name)")
     public void sortingCustomersByFirstNameTest() {
        mainPage = new MainPage(driver);
        Waiters.waitVisibilityElement(mainPage.customersButton, wait);
        mainPage.clickButtonCustomer();
        customersPage = new Customers(driver);
        Waiters.waitVisibilityElement(customersPage.customersButton, wait);
        customersPage = new Customers(driver);
        Waiters.waitVisibilityElement(customersPage.table, wait);
        List<WebElement> listRowBeforeClickOnFirstName = customersPage.rowsFromTableCustomer;
        int sizeList = listRowBeforeClickOnFirstName.size();
        if (sizeList == 0) {
            Assertions.fail("Пустой список клиентов после перехода на вкладку Customers");
        }
        listRowBeforeClickOnFirstName.sort(Comparator.comparing(o -> o.getText().split(" ")[0]));
        customersPage.sortForFirstName();
        // Ждем именно когда появится строка. Таблица уже есть
        Waiters.waitVisibilityElement(customersPage.row, wait);
        List<WebElement> listRowSortedAfterClickOnFirstName = customersPage.rowsFromTableCustomer;

        boolean isSorted = listRowSortedAfterClickOnFirstName.equals(listRowBeforeClickOnFirstName);
        Assertions.assertTrue(isSorted, "Сортировка списка клиентов не соответствует ожиданием ");
    }
}
