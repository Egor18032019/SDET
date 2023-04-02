package tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import pages.AddCustomer;
import pages.Customers;
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
    Customers customersPage;
    AddCustomer addCustomerPage;

    @Test
    @Description("Поиск клиента по имени")
    public void searchCustomerByFirstNameTest() {
        mainPage = new MainPage(driver);
        Waiters.waitVisibilityElement(mainPage.customersButton, BaseCaseTest.wait);
        mainPage.clickButtonAddCustomer();
        addCustomerPage = new AddCustomer(driver);
        Waiters.waitVisibilityElement(addCustomerPage.createAccountButton, wait);
        Helpers.creatingCustomer(Const.firstName, Const.lastName, Const.postalCode, addCustomerPage, driver, wait);
        mainPage.clickButtonCustomer();
        customersPage = new Customers(driver);
        String searchByFirstName = Const.firstName;
        List<WebElement> listRows = Helpers.searchCustomer(searchByFirstName, customersPage, wait);

        boolean testDone = Helpers.isContainsSearchString(searchByFirstName, listRows);

        Assertions.assertTrue(testDone, "The added customer was not found by name");
    }

    @Test
    @Description("Поиск клиента по фамилии")
    public void searchCustomerByLastNameTest() {
        mainPage = new MainPage(driver);
        Waiters.waitVisibilityElement(mainPage.customersButton, BaseCaseTest.wait);
        mainPage.clickButtonAddCustomer();
        addCustomerPage = new AddCustomer(driver);
        Waiters.waitVisibilityElement(addCustomerPage.createAccountButton, wait);
        Helpers.creatingCustomer(Const.firstName, Const.lastName, Const.postalCode, addCustomerPage, driver, wait);
        mainPage.clickButtonCustomer();
        customersPage = new Customers(driver);
        String searchByLastName = Const.lastName;
        List<WebElement> listRows = Helpers.searchCustomer(searchByLastName, customersPage, wait);

        boolean testDone = Helpers.isContainsSearchString(searchByLastName, listRows);
        Assertions.assertTrue(testDone, "The added customer was not found by last name");
    }


    @Test
    @Description("Поиск клиента по почтовому индексу")
    public void searchCustomerByPostalCodeTest() {
        mainPage = new MainPage(driver);
        Waiters.waitVisibilityElement(mainPage.customersButton, BaseCaseTest.wait);
        mainPage.clickButtonAddCustomer();
        addCustomerPage = new AddCustomer(driver);
        Waiters.waitVisibilityElement(addCustomerPage.createAccountButton, wait);
        Helpers.creatingCustomer(Const.firstName, Const.lastName, Const.postalCode, addCustomerPage, driver, wait);
        mainPage.clickButtonCustomer();
        customersPage = new Customers(driver);
        String searchByPostalCode = Const.postalCode;
        List<WebElement> listRows = Helpers.searchCustomer(searchByPostalCode, customersPage, wait);

        boolean testDone = Helpers.isContainsSearchString(searchByPostalCode, listRows);
        Assertions.assertTrue(testDone, "The added customer was not found by postal code");
    }

}
