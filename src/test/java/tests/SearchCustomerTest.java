package tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import pages.MainPage;
import tests.base.BaseCaseTest;
import utils.Const;
import utils.Helpers;
import utils.Waiters;

import java.util.List;

/**
 * Тест кейс T3
 * Поиск клиента
 */
public class SearchCustomerTest extends BaseCaseTest {
    MainPage mainPage;
    @Test
    @Description("Поиск клиента")
    public void searchCustomerTest() {
        mainPage = new MainPage(driver);
        Waiters.waitVisibilityElement(mainPage.addCustomerButton, BaseCaseTest.wait);
        mainPage.clickButtonAddCustomer();
        Waiters.waitVisibilityElement(mainPage.createAccountButton, BaseCaseTest.wait);
        Helpers.addCustomer(Const.firstName, Const.lastName, Const.postalCode, mainPage, driver);

        Waiters.waitVisibilityElement(mainPage.customersButton, BaseCaseTest.wait);
        mainPage.clickButtonCustomer();
        Waiters.waitVisibilityElement(mainPage.searchCustomerInput, BaseCaseTest.wait);
        mainPage.searchCustomer(Const.firstName);
        List<WebElement> table = mainPage.rowsFromTableCustomer;
        boolean cellHaveFirstName = false; //если лист пустой то тест не пройдет
        for (int i = 0; i < table.size(); i++) {
            String row = table.get(i).getText().split(" ")[0];
            cellHaveFirstName = row.contains(Const.firstName);
            if (!cellHaveFirstName) break;
        }
        Assertions.assertTrue(cellHaveFirstName, "the search failed");
    }
}
