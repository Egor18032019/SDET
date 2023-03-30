package cases;

import cases.base.BaseCase;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import pages.MainPage;

public class FirstCaseTest extends BaseCase {
    MainPage mainPage;

    //TODO ограничение работы теста
    // TODO проверка перед запуском есть ли интернет
    @Test
    @Issue("T1")
    @Description("Создание клиента (Customer)")
    public void fistCase() {
        System.out.println("fistCase");
        mainPage = new MainPage(driver);
        mainPage.clickButtonAddCustomer();
        String firstName = "first";
        String lastName = "last";
        String postalCode = "620024";
        mainPage.creatCostumer(firstName, lastName, postalCode);
        Alert alert = driver.switchTo().alert();
        String textOnAlert = alert.getText();
        boolean iaAdded = textOnAlert.startsWith("Customer added successfully with customer id");
        Assertions.assertTrue(iaAdded, "not added");
    }
}