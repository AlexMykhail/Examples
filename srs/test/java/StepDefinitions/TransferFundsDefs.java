package StepDefinitions;

import Objects.MainPage;
import Objects.TransferFundsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class TransferFundsDefs {

    private WebDriver driver;
    private TransferFundsPage transferFundsPage;
    private TestContext testContext;
    private MainPage mainPage;


    public TransferFundsDefs(TestContext testContext){
        driver = testContext.getDriver();
        transferFundsPage = new TransferFundsPage(driver);
        mainPage = new MainPage(driver);
    }

    @Given("^User navigates to \"Transfer Funds\" page$")
    public void navigatesToTransferFunds() {
        mainPage.clickTransferFunds();
    }
    @When("^randomly selects From account$")
    public void randomlySelectsFromAccount() {
        transferFundsPage.selectRandomFromAccount();
    }
    @And("^randomly selects To account$")
    public void randomlySelectsToAccount() {
        transferFundsPage.selectRandomToAccount();
    }
    @And("^sets amount \"([^\"]*)\"$")
    public void setsAmount(String amount) {
        transferFundsPage.setAmount(amount);
    }
    @And("^sets description \"([^\"]*)\"$")
    public void setsDescription(String description) {
        transferFundsPage.setDescription(description);
    }
    @And("^clicks Continue button$")
    public void clicksButton() {
        transferFundsPage.clickContinueBtn();
    }
    @Then("^checks Input data$")
    public void checksInputData() {
        Assert.assertTrue(transferFundsPage.getOrderedFromAccount().contains(transferFundsPage.getSuccessFromAccount()));
        Assert.assertTrue(transferFundsPage.getOrderedToAccount().contains(transferFundsPage.getSuccessToAccount()));
        Assert.assertEquals(transferFundsPage.getOrderedAmount(), transferFundsPage.getSuccessAmount());
        Assert.assertEquals(transferFundsPage.getOrderedDescription(), transferFundsPage.getSuccessDescription());
    }
    @And("^clicks Submit button$")
    public void clicksSubmitButton() {
        transferFundsPage.clickSubmitBtn();
    }
    @Then("^\"([^\"]*)\" message is shown$")
    public void messageIsShown(String message) {
        String alertText = transferFundsPage.getMessage();
        Assert.assertEquals(alertText, message);
    }
}


