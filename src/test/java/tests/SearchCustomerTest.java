package tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.Customers;
import pages.MainPage;
import tests.base.BaseCaseTest;
import utils.Const;
import utils.Helpers;
import utils.Waiters;

/**
 * Тест кейс T3
 * Поиск клиента
 */
public class SearchCustomerTest extends BaseCaseTest {
    MainPage mainPage;
    Customers customers;
    @Test
    @Description("Поиск клиента по имени")
    public void searchCustomerByFirstNameTest() {
        mainPage = new MainPage(driver);
        Waiters.waitVisibilityElement(mainPage.addCustomerButton, wait);
        mainPage.clickButtonAddCustomer();
        Waiters.waitVisibilityElement(mainPage.createAccountButton, wait);
        String searchByFirstName = Const.firstName;
        boolean testDone = Helpers.isContainsSearchString(searchByFirstName, Const.firstName, Const.lastName, Const.postalCode, mainPage, driver, wait);

        Assertions.assertTrue(testDone, "The added customer was not found by name");
    }

    @Test
    @Description("Поиск клиента по фамилии")
    public void searchCustomerByLastNameTest() {
        mainPage = new MainPage(driver);
        Waiters.waitVisibilityElement(mainPage.addCustomerButton, wait);
        mainPage.clickButtonAddCustomer();
        Waiters.waitVisibilityElement(mainPage.createAccountButton, wait);
        String searchByLastName = Const.lastName;
        boolean testDone = Helpers.isContainsSearchString(searchByLastName, Const.firstName, Const.lastName, Const.postalCode, mainPage, driver, wait);

        Assertions.assertTrue(testDone, "The added customer was not found by last name");
    }

    @Test
    @Description("Поиск клиента по почтовому индексу")
    public void searchCustomerByPostalCodeTest() {
        mainPage = new MainPage(driver);
        Waiters.waitVisibilityElement(mainPage.addCustomerButton, wait);
        mainPage.clickButtonAddCustomer();
        Waiters.waitVisibilityElement(mainPage.createAccountButton, wait);
        String searchByPostalCode = Const.postalCode;
        boolean testDone = Helpers.isContainsSearchString(searchByPostalCode, Const.firstName, Const.lastName, Const.postalCode, mainPage, driver, wait);

        Assertions.assertTrue(testDone, "The added customer was not found by postal code");
    }
}
