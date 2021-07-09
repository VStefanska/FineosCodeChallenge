package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static support.BrowserUtils.waitUntilElementToBeClickable;
import static support.Driver.getDriver;

public class HomePage extends BasePage {

    //Dynamic XPath for Customer radio buttons that finds element by text
    private final String customerRadioButtonsXPath = "//label[text()='%s']/input";
    //Dynamic XPath to locate deleteUserButton by User Name
    private final String deleteUserButtonXPath = "//td[text()='%s']/../td/button[@ng-click='delUser()']";
    //Dynamic XPath user row by text
    private final String userRowXPath = "//td[text()='%s']/..";

    @FindBy(css = ".pull-right.btn-link")
    private WebElement addUserButton;
    @FindBy(css = ".modal")
    private WebElement addUserPopUpWindow;
    @FindBy(xpath = "//*[@name='FirstName']")
    private WebElement firstNameField;
    @FindBy(xpath = "//*[@name='LastName']")
    private WebElement lastNameField;
    @FindBy(xpath = "//*[@name='UserName']")
    private WebElement userNameField;
    @FindBy(xpath = "//*[@name='Password']")
    private WebElement passwordField;
    @FindBy(xpath = "//select[@name='RoleId']")
    private WebElement roleDropdown;
    @FindBy(xpath = "//*[@name='Email']")
    private WebElement emailField;
    @FindBy(xpath = "//*[@name='Mobilephone']")
    private WebElement cellPhoneField;
    @FindBy(xpath = "//*[@ng-click='save(user)']")
    private WebElement saveButton;
    @FindBy(css = ".modal-footer .btn-success")
    private WebElement zdarova;
    @FindBy(css = ".modal.ng-scope")
    private WebElement confirmationDialog;
    @FindBy(css = ".btn-primary")
    private WebElement confirmationDialogOKButton;
    @FindBy(xpath = "//tbody")
    private WebElement webTable;


    public void clickAddUserButton() {
        addUserButton.click();
    }

    public boolean isAddUserWindowPresent() {
        return addUserPopUpWindow.isDisplayed();
    }

    public void fillOutFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    public void fillOutLastName(String lastName) {
        lastNameField.sendKeys(lastName);
    }

    public void fillOutUserName(String userName) {
        userNameField.sendKeys(userName);
    }

    public void fillOutPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void fillOutEmail(String email) {
        emailField.sendKeys(email);
    }

    public void fillOutCellPhone(String cellPhone) {
        cellPhoneField.sendKeys(cellPhone);
    }

    public void clickCustomerRadioButtonByText(String customer) {
        getDriver().findElement(By.xpath(String.format(customerRadioButtonsXPath, customer))).click();
    }

    public void selectRoleByText(String role) {
        Select selectRole = new Select(roleDropdown);
        selectRole.selectByVisibleText(role);
    }

    public void clickSaveButton() {

        waitUntilElementToBeClickable(saveButton, 3);
        saveButton.click();
    }

    public void deleteUserByUserName(String userName) {
        getDriver().findElement(By.xpath(String.format(deleteUserButtonXPath, userName))).click();
    }

    public boolean isUserPresent(String userName) {
        return getDriver().findElement(By.xpath(String.format(userRowXPath, userName))).isDisplayed();
    }

    public boolean isConfirmationDialogDisplayed() {
        return confirmationDialog.isDisplayed();
    }

    public void clickOKConfirmationDialog() {
        confirmationDialogOKButton.click();
    }

    public boolean isWebTableContainsText(String text) {
        return webTable.getText().contains(text);
    }
}
