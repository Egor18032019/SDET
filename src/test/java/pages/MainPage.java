package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

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
     * Строка таблицы из вкладки Customer
     */
    @FindBy(css = ".ng-binding")
    public WebElement row;
    /**
     * Поле для текстового вода First name
     */
    @FindBy(xpath = "//input[@ng-model='fName']")
    WebElement firstNameInput;
    /**
     * Поле для текстового вода Last name
     */
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastNameInput;
    /**
     * Поле для текстового вода используемая для поиска клиента
     */
    @FindBy(xpath = "//input[@placeholder='Search Customer']")
    WebElement searchCustomerInput;
    @FindBy(linkText = "First Name")
    WebElement sortLinkFirsName;
    /**
     * Поле для текстового вода Post Code
     */
    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement postalCodeInput;

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
    public void creaNewtCustomer(String first, String last, String postal) {
        setTextElementText(firstNameInput, first);
        setTextElementText(lastNameInput, last);
        setTextElementText(postalCodeInput, postal);
        clickButton(createAccountButton);
    }

    @Step("Поиск клиента")
    public void searchCustomer(String name) {
        setTextElementText(searchCustomerInput, name);
    }

    @Step("Нажали на First name")
    public void sortForFirstName() {
        clickButton(sortLinkFirsName);
    }
}