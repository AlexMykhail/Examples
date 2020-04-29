package StepDefinitions;

import Objects.AccountSummary;
import Objects.Login;
import Objects.MainPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class LoginDefs {

    private WebDriver driver;
    final String URL = "http://zero.webappsecurity.com";
    private MainPage mainPage;
    private Login login;
    private AccountSummary accountSummary;

    public LoginDefs(TestContext testContext) {
        this.driver = testContext.getDriver();
        this.mainPage = new MainPage(driver);
        this.login = new Login(driver);
        this.accountSummary = new AccountSummary(driver);
    }


    @Given("^Login to the app with credentials$")
    public void loginToTheAppWithCredential(DataTable table) {
        List<String> rawData = table.asList(String.class);
        this.driver.get(URL);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        mainPage.clickSignInBtn();
        login.doLogin(rawData.get(0), rawData.get(1));
    }


    @When("^User navigates to the \"([^\"]*)\" page$")
    public void userNavigatesToThePage(String pageName) {
        switch (pageName) {
            case "Transfer Funds":
                this.accountSummary.clickTransferFunds();
                break;
            case "Add New Payee":
                this.accountSummary.clickPayBills();
                this.accountSummary.clickAddNewPayee();
                break;
            case "Pay Saved Payee":
                this.accountSummary.clickPayBills();
                break;
        }
    }

}
