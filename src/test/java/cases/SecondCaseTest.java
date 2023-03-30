package cases;

import cases.base.BaseCase;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.MainPage;

import java.util.List;

public class SecondCaseTest extends BaseCase {
    MainPage mainPage;


    @Test
    @Issue("T2")
    @Description("Сортировка клиентов по имени (First Name)")
    public void secondCase() {
        System.out.println("secondCase");
        mainPage = new MainPage(driver);
        mainPage.clickButtonCustomer();
        mainPage.sortedForFirstName();
        List<WebElement> table = driver.findElements(By.xpath("//table/tbody/tr[@class='ng-scope']"));

        // по умолчанию сортировка в первый клик идет в обратном алфавитном порядке.
        // в тз не было описано какой порядок должен быть
        boolean isSorted = true;
        for (int i = 0; i < table.size() - 1; i++) {
            String rowA = table.get(i).getText().split(" ")[0];
            String rowB = table.get(i + 1).getText().split(" ")[0];
            isSorted = rowA.compareTo(rowB) >= rowB.compareTo(rowA);
            if (!isSorted) break;
        }
        Assertions.assertTrue(isSorted);
    }
}
