package tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceLock;
import pages.AddCustomer;
import pages.MainPage;
import tests.base.BaseCaseTest;
import utils.Const;
import utils.Waiters;

/**
 * Тест кейс T1
 * Создание клиента (Customer)
 */
public class CreatingCustomerTest extends BaseCaseTest {
    MainPage mainPage;
    AddCustomer addCustomer;

    @Test
    @Description("Создание клиента (Customer)")
    @ResourceLock(value = "mainPage")
    @ResourceLock(value = "addCustomer")
    @ResourceLock(value = "driver")
    public void creatingCustomerTest() {
        mainPage = new MainPage(driver);
        Waiters.waitVisibilityElement(mainPage.addCustomerButton, wait);
        mainPage.clickButtonAddCustomer();
        addCustomer = new AddCustomer(driver);
        Waiters.waitVisibilityElement(addCustomer.createAccountButton, wait);
        addCustomer.creatingCustomer(Const.firstName, Const.lastName, Const.postalCode, driver, wait);
    }
}