package StepDefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestContext {

    private WebDriver driver;


    @Before
    public void initialiseMainElements() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Alexander\\Desktop\\FORTE\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void afterTest() {
        driver.close();
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}

