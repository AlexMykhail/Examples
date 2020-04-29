package StepDefinitions;

import Objects.AddNewPayeePage;
import Objects.SavedPayeePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;



public class AddPayeeSavedPayeeStepDefs {


    private WebDriver driver;
    private AddNewPayeePage addNewPayeePage;
    private SavedPayeePage savedPayeePage;


    public AddPayeeSavedPayeeStepDefs(TestContext testContext) {
        this.driver = testContext.getDriver();
        this.addNewPayeePage = new AddNewPayeePage(driver);
        this.savedPayeePage = new SavedPayeePage(driver);
    }

    @And("^User types \"([^\"]*)\" as user's name$")
    public void userTypesAsUserName (String payeeName) {
        addNewPayeePage.setPayeeName(payeeName);
    }

    @And("^User types \"([^\"]*)\" as address$")
    public void userTypesAsAddress (String payeeAddress) {
        addNewPayeePage.setPayeeAddress(payeeAddress);
    }

    @And("^User types \"([^\"]*)\" as account number$")
    public void userTypesAsAccountNumber (String payeeAccount) {
        addNewPayeePage.setPayeeAccount(payeeAccount);
    }

    @And("^User types \"([^\"]*)\" as details$")
    public void userTypesUserDetailsAsDetails (String payeeDetails) {
        addNewPayeePage.setPayeeDetails(payeeDetails);
    }

    @And("^^User clicks on Add button$")
    public void userClicksOnAddButton() {
        addNewPayeePage.clickAddBtn();
    }

    @Then("^\"([^\"]*)\" success message is shown$")
    public void successMessageIsShown(String message) {
        String alertText = addNewPayeePage.getMessage();
        Assert.assertEquals(alertText, message);
    }






    @And("^User randomly selects Payee$")
    public void userRandomlySelectsPayee() {
        savedPayeePage.selectRandomPayeeSelect();
    }

    @And("^User randomly selects Account$")
    public void userRandomlySelectsAccount() { savedPayeePage.selectRandomPayeeAccount();
    }

    @And("^User types \"([^\"]*)\" as amount$")
    public void userTypesAsAmount(String amount) {
        savedPayeePage.setAmount(amount);
    }

    @And("^User types \"([^\"]*)\" as date$")
    public void userTypesAsDate(String date) {
        savedPayeePage.setDate(date);
    }

    @And("^User types \"([^\"]*)\" as description$")
    public void userTypesAsDescription(String description) {
        savedPayeePage.setDescription(description);
    }

    @And("^User clicks Pay button$")
    public void userClicksButton() {
        savedPayeePage.clickContinueBtn();
    }

    @Then("^\"([^\"]*)\" submit message is shown$")
    public void submitMessageIsShown(String message) {
        String alertText = savedPayeePage.getMessage();
        Assert.assertEquals(alertText, message);
    }

}
