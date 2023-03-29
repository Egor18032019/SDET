package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.PageBase;

public class MainPage extends PageBase {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/button[1]")
    public WebElement addCustomer;

    @FindBy(xpath = "//button[contains(text(),'Open Account')]")
    public WebElement openAccount;
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div[2]/div/div/form/button")
    public WebElement creatAccount;
    @FindBy(xpath = "//button[@ng-class='btnClass3']")
    public WebElement customers;

    @FindBy(css = ".ng-binding")
    public WebElement row;
    @FindBy(xpath = "//input[@ng-model='fName']")
    WebElement firstName;
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastName;
    @FindBy(xpath = "//input[@placeholder='Search Customer']")
    WebElement inputSearchCustomer;
    @FindBy(linkText = "First Name")
    WebElement sortLinkFirsName;
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/div/div/form/div[3]/input")
    WebElement postalCode;

    public void clickButtonAddCustomer() {
        clickButton(addCustomer);
    }

    public void clickButtonOpenAccount() {
        clickButton(openAccount);
    }

    public void clickButtonCustomer() {
        clickButton(customers);
    }

    public void creatCostumer(String first, String last, String postal) {
        setTextElementText(firstName, first);
        setTextElementText(lastName, last);
        setTextElementText(postalCode, postal);
        clickButton(creatAccount);
    }

    public void searchCostumer(String name) {
        setTextElementText(inputSearchCustomer, name);
    }

    @Step("Нажали на First name")
    public void sortedForFirstName() {
        clickButton(sortLinkFirsName);
        System.out.println("Нажали на First name");
    }
}