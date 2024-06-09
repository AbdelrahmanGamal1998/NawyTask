package DemoPlazeTest;

import DemoPlazePages.LoginPage;
import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest {

    private SHAFT.GUI.WebDriver driver;
    private SHAFT.TestData.JSON testData;


    @Test(description = "Verify navigation to the Test Cases page from the homepage")
    public void verifyTestCasePage() {
        new LoginPage(driver).login(testData.getTestData("login.username"), testData.getTestData("login.password"))
                .validateTheLoggedUser(testData.getTestData("login.username"));
    }
    @BeforeClass
    public void beforeClass() {
        driver = new SHAFT.GUI.WebDriver();
        driver.browser().navigateToURL("https://demoblaze.com/index.html");
        testData = new SHAFT.TestData.JSON("login.json");
    }
    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

}