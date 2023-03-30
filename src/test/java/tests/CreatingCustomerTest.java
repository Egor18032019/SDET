package tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.MainPage;
import tests.base.BaseCaseTest;
import utils.Const;

public class CreatingCustomerTest extends BaseCaseTest {
    MainPage mainPage;

    @Test
    @Description("Создание клиента (Customer)")
    public void creatingCustomerTest() {
        mainPage = new MainPage(driver);
        BaseCaseTest.wait.until(ExpectedConditions.visibilityOf(mainPage.addCustomerButton));
        mainPage.clickButtonAddCustomer();
        BaseCaseTest.wait.until(ExpectedConditions.visibilityOf(mainPage.createAccountButton));
        mainPage.creatNewCustomer(Const.firstName, Const.lastName, Const.postalCode);
        BaseCaseTest.wait.until(ExpectedConditions.alertIsPresent());
        String textOnAlert = mainPage.giveMeAlertText(driver);
        boolean iaAdded = textOnAlert.startsWith(Const.expectedTextAfterCreatNewCustomer);
        Assertions.assertTrue(iaAdded, "New customer not added");
    }


}