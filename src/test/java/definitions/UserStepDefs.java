package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.UserModel;
import model.UserUtility;
import pages.HomePage;

import static org.assertj.core.api.Assertions.assertThat;
import static support.Driver.getDriver;

public class UserStepDefs {

    UserModel user = UserUtility.generateUserModel();
    HomePage homePage = new HomePage();

    @Given("I navigate to Way2Automation {string}")
    public void iNavigateToWayAutomation(String page) {
        switch (page) {
            case "webtables":
                getDriver().get("http://www.way2automation.com/angularjs-protractor/webtables/");
                break;
            default:
                throw new IllegalArgumentException("This page isn't supported: " + page);
        }
    }

    @When("I click Add User button")
    public void iClickAddUserButton() {
        homePage.clickAddUserButton();
    }

    @Then("Add User pop up window is present")
    public void addUserPopUpWindowIsPresent() {
        assertThat(homePage.isAddUserWindowPresent()).isTrue();
    }


    @Then("New user is added to webtable")
    public void newUserIsAddedToWebtable() {
        assertThat(homePage.isUserPresent(user.getUserName())).isTrue();
    }

    @When("I fill out all fields")
    public void iFillOutAllFields() throws InterruptedException {
        homePage.fillOutFirstName(user.getFirstName());
        homePage.fillOutLastName(user.getLastName());
        homePage.fillOutUserName(user.getUserName());
        homePage.fillOutPassword(user.getPassword());
        homePage.clickCustomerRadioButtonByText(user.getCustomer());
        homePage.selectRoleByText(user.getRole());
        homePage.fillOutEmail(user.getEmail());
        homePage.fillOutCellPhone(user.getCellPhone());
    }


    @When("I delete user with User Name {string}")
    public void iDeleteUserWithUserName(String userName) throws InterruptedException {
        homePage.deleteUserByUserName(userName);
    }

    @Then("User with User Name {string} is deleted and not present in table")
    public void userWithUserNameIsDeletedAndNotPresentInTable(String userName) {
        assertThat(homePage.isWebTableContainsText(userName)).isFalse();
    }

    @And("I click Save button")
    public void iClickSaveButton() {
        homePage.clickSaveButton();
    }

    @Then("Confirmation dialog is displayed")
    public void confirmationDialogIsDisplayed() {
        assertThat(homePage.isConfirmationDialogDisplayed()).isTrue();
    }

    @When("I click Ok")
    public void iClickOk() {
        homePage.clickOKConfirmationDialog();
    }
}
