package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import pages.MainPage;
import tests.base.BaseCaseTest;
import utils.Waiters;
import java.util.Comparator;
import java.util.List;
/**
 * Тест кейс T3
 * Поиск клиента
 */
public class SortingCustomersByFirstNameTest extends BaseCaseTest {
    MainPage mainPage;

    @Test
    @Issue("T2")
    @Description("Сортировка клиентов по имени (First Name)")
    public void sortingCustomersByFirstNameTest() {
        mainPage = new MainPage(driver);
        Waiters.waitVisibilityElement(mainPage.customersButton, BaseCaseTest.wait);
        mainPage.clickButtonCustomer();
        Waiters.waitVisibilityElement(mainPage.table, BaseCaseTest.wait);
        List<WebElement> listRowBeforeClickOnFirstName = mainPage.rowsFromTableCustomer;
        int sizeList = listRowBeforeClickOnFirstName.size();
        if (sizeList == 0) {
            Assertions.fail("Пустой список клиентов после перехода на вкладку Customers");
        }
        listRowBeforeClickOnFirstName.sort(Comparator.comparing(o -> o.getText().split(" ")[0]));
        mainPage.sortForFirstName();
        // Ждем именно когда появится строка. Таблица уже есть
        Waiters.waitVisibilityElement(mainPage.row, BaseCaseTest.wait);
        List<WebElement> listRowSortedAfterClickOnFirstName = mainPage.rowsFromTableCustomer;

        boolean isSorted = listRowSortedAfterClickOnFirstName.equals(listRowBeforeClickOnFirstName);
        Assertions.assertTrue(isSorted);
    }
}
