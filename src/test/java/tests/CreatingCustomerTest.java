package tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
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

    @Test
    @Description("Создание клиента (Customer)")
    public void creatingCustomerTest() {
        mainPage = new MainPage(driver);
        Waiters.waitVisibilityElement(mainPage.addCustomerButton, BaseCaseTest.wait);
        mainPage.clickButtonAddCustomer();
        Waiters.waitVisibilityElement(mainPage.createAccountButton, BaseCaseTest.wait);
    }
}