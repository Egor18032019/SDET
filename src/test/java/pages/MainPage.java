package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import pages.base.BasePage;

import java.util.List;

/**
 * Главная страница
 */
public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }
    /**
     * Кнопка <Add Customer>
     */
    @FindBy(xpath = "//button[contains(text(),'Add Customer')]")
    public WebElement addCustomerButton;
    /**
     * Кнопка <Open Account>
     */
    @FindBy(xpath = "//button[contains(text(),'Open Account')]")
    public WebElement openAccountButton;
    /**
     * Кнопка <Add Customer> расположенная после(ниже) полей для текстового вода
     */
    @FindBy(xpath = "//button[contains(text(),'Add Customer')][@class='btn btn-default']")
    public WebElement createAccountButton;
    /**
     * Кнопка <Customers>
     */
    @FindBy(xpath = "//button[@ng-class='btnClass3']")
    public WebElement customersButton;
    /**
     * Таблица на вкладке Customers
     */
    @FindBy(xpath = "//table[@class='table table-bordered table-striped']")
    public WebElement table;
    /**
     * Строка таблицы из вкладки Customer
     */
    @FindBy(css = ".ng-binding")
    public WebElement row;
    /**
     * Поле для текстового вода First name
     */
    @FindBy(xpath = "//input[@ng-model='fName']")
    public WebElement firstNameInput;
    /**
     * Поле для текстового вода Last name
     */
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    public WebElement lastNameInput;
    /**
     * Поле для текстового вода используемая для поиска клиента
     */
    @FindBy(xpath = "//input[@placeholder='Search Customer']")
    public WebElement searchCustomerInput;
    /**
     * Ячейка в таблице клиентов надписью "First Name"
     */
    @FindBy(linkText = "First Name")
    public WebElement sortLinkFirsName;
    /**
     * Поле для текстового вода Post Code
     */
    @FindBy(xpath = "//input[@placeholder='Post Code']")
    public WebElement postalCodeInput;

    @FindBys({@FindBy(xpath = "//tr[@class='ng-scope']")})
    public List<WebElement> rowsFromTableCustomer;

    @Step("Нажатие на кнопку Add Customer для перехода на вкладку создание клиентов")
    public void clickButtonAddCustomer() {
        clickButton(addCustomerButton);
    }

    @Step("Нажатие на кнопку Open Customer для перехода на вкладку поиска клиентов")
    public void clickButtonOpenAccount() {
        clickButton(openAccountButton);
    }

    @Step("Нажатие на кнопку Customer для перехода на вкладку поиска клиентов")
    public void clickButtonCustomer() {
        clickButton(customersButton);
    }

    @Step("Создание клиента")
    public void creatNewCustomer(String firstName, String lastName, String postalCode) {
        setTextElementText(firstNameInput, firstName);
        setTextElementText(lastNameInput, lastName);
        setTextElementText(postalCodeInput, postalCode);
        clickButton(createAccountButton);
    }

    @Step("Поиск клиента {name}")
    public void searchCustomer(String name) {
        setTextElementText(searchCustomerInput, name);
    }

    @Step("Нажали на First name")
    public void sortForFirstName() {
        clickButton(sortLinkFirsName);
    }

    @Step("Получение текста alerta(модального окна)")
    public String giveMeAlertText(WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }
}