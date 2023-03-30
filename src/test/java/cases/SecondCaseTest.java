package cases;

import cases.base.BaseCase;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
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
        List<WebElement> listRow = mainPage.rowsFromTableCustomer;

        // по умолчанию сортировка в первый клик идет в обратном алфавитном порядке.
        // в тз не было описано какой порядок должен быть
        boolean isSorted = true;
        for (int i = 0; i < listRow.size() - 1; i++) {
            String rowCurrent = listRow.get(i).getText().split(" ")[0];
            String rowNext = listRow.get(i + 1).getText().split(" ")[0];
            isSorted = rowCurrent.compareTo(rowNext) >= rowNext.compareTo(rowCurrent);
            if (!isSorted) break;
        }
        Assertions.assertTrue(isSorted);
    }
}
