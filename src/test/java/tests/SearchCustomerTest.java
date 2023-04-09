package tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.api.parallel.ResourceLock;
import org.openqa.selenium.WebElement;
import pages.AddCustomer;
import pages.Customers;
import pages.MainPage;
import tests.base.BaseCaseTest;
import utils.Const;
import utils.Helpers;
import utils.Waiters;

import java.util.List;

import static org.junit.jupiter.api.parallel.ExecutionMode.CONCURRENT;

/**
 * Тест кейс T3
 * Поиск клиента
 */
@Execution(CONCURRENT)
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
 public class SearchCustomerTest extends BaseCaseTest {
    MainPage mainPage;
    Customers customersPage;
    AddCustomer addCustomerPage;

    @Test
    @Description("Поиск клиента по имени")
     public void searchCustomerByFirstNameTest() {
        mainPage = new MainPage(driver);
        Waiters.waitVisibilityElement(mainPage.customersButton, wait);
        mainPage.clickButtonAddCustomer();
        addCustomerPage = new AddCustomer(driver);
        Waiters.waitVisibilityElement(addCustomerPage.createAccountButton, wait);
        addCustomerPage.creatingCustomer(Const.firstName, Const.lastName, Const.postalCode, driver, wait);
        mainPage.clickButtonCustomer();
        customersPage = new Customers(driver);
        String searchByFirstName = Const.firstName;
        List<WebElement> listRows = customersPage.searchCustomer(searchByFirstName, wait);
        boolean testDone = Helpers.isContainsSearchString(searchByFirstName, listRows);

        Assertions.assertTrue(testDone, "The added customer was not found by name");
    }

    @Test
    @Description("Поиск клиента по фамилии")
     public void searchCustomerByLastNameTest() {
        mainPage = new MainPage(driver);
        Waiters.waitVisibilityElement(mainPage.customersButton, wait);
        mainPage.clickButtonAddCustomer();
        addCustomerPage = new AddCustomer(driver);
        Waiters.waitVisibilityElement(addCustomerPage.createAccountButton, wait);
        addCustomerPage.creatingCustomer(Const.firstName, Const.lastName, Const.postalCode, driver, wait);
        mainPage.clickButtonCustomer();
        customersPage = new Customers(driver);
        String searchByLastName = Const.lastName;
        List<WebElement> listRows = customersPage.searchCustomer(searchByLastName, wait);

        boolean testDone = Helpers.isContainsSearchString(searchByLastName, listRows);
        Assertions.assertTrue(testDone, "The added customer was not found by last name");
    }

    @Test
    @Description("Поиск клиента по почтовому индексу")
     public void searchCustomerByPostalCodeTest() {
        mainPage = new MainPage(driver);
        Waiters.waitVisibilityElement(mainPage.customersButton, wait);
        mainPage.clickButtonAddCustomer();
        addCustomerPage = new AddCustomer(driver);
        Waiters.waitVisibilityElement(addCustomerPage.createAccountButton, wait);
        addCustomerPage.creatingCustomer(Const.firstName, Const.lastName, Const.postalCode, driver, wait);
        mainPage.clickButtonCustomer();
        customersPage = new Customers(driver);
        String searchByPostalCode = Const.postalCode;
        List<WebElement> listRows = customersPage.searchCustomer(searchByPostalCode, wait);

        boolean testDone = Helpers.isContainsSearchString(searchByPostalCode, listRows);
        Assertions.assertTrue(testDone, "The added customer was not found by postal code");
    }
}
