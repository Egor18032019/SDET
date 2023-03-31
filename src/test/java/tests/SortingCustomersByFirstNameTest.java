package tests;


import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import pages.MainPage;
import tests.base.BaseCaseTest;
import utils.Waiters;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingCustomersByFirstNameTest extends BaseCaseTest {
    MainPage mainPage;

    @Test
    @Issue("T2")
    @Description("Сортировка клиентов по имени (First Name)")
    public void sortingCustomersByFirstName() {
        mainPage = new MainPage(driver);
        Waiters.waitVisibilityElement(mainPage.customersButton, BaseCaseTest.wait);
        mainPage.clickButtonCustomer();
        Waiters.waitVisibilityElement(mainPage.table, BaseCaseTest.wait);
        List<WebElement> listRowBeforeClickOnFirstName = mainPage.rowsFromTableCustomer;
        int sizeList = listRowBeforeClickOnFirstName.size();
        if (sizeList == 0) {
            Assertions.fail("Пустой список");
            return;
        }
        Collections.sort(listRowBeforeClickOnFirstName, Comparator.comparing(o -> o.getText().split(" ")[0]));
        mainPage.sortForFirstName();
        Waiters.waitVisibilityElement(mainPage.row, BaseCaseTest.wait);
        // Ждем именно когда появится строка. Таблица уже есть
        List<WebElement> listRowSortedAfterClickOnFirstName = mainPage.rowsFromTableCustomer;

        boolean isSorted = true;
        for (int i = 0; i < sizeList - 1; i++) {
            String rowBeforeClickButSortedThis = listRowSortedAfterClickOnFirstName.get(i).getText().split(" ")[0];
            String rowAfterClick = listRowBeforeClickOnFirstName.get(i).getText().split(" ")[0];
            isSorted = rowBeforeClickButSortedThis.equals(rowAfterClick);
            if (!isSorted) break;
        }
        Assertions.assertTrue(isSorted);
    }
}
