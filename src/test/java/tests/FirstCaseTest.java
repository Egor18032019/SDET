package tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import pages.MainPage;
import tests.base.BaseCase;
import utils.Const;

public class FirstCaseTest extends BaseCase {
    MainPage mainPage;


    @Test
    @Description("Создание клиента (Customer)")
    public void creatingCustomer() {
        mainPage = new MainPage(driver);
        mainPage.clickButtonAddCustomer();

        mainPage.creaNewtCustomer(Const.firstName, Const.lastName, Const.postalCode);

        String textOnAlert = giveMeAlertText();
        boolean iaAdded = textOnAlert.startsWith(Const.currentTextAfterCreatNewCustomer);
        Assertions.assertTrue(iaAdded, "New customer not added");
    }

    public String giveMeAlertText() {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }
}