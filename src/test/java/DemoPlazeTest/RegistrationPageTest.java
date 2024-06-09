package DemoPlazeTest;

import DemoPlazePages.LoginPage;
import DemoPlazePages.RegistrationPage;
import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegistrationPageTest {
    private SHAFT.GUI.WebDriver driver;
    private String timeStamp = String.valueOf(System.currentTimeMillis());
    private SHAFT.TestData.JSON testData;


    @Test(description = "Verify navigation to the Test Cases page from the homepage")
    public void verifyTestCasePage() {
        new RegistrationPage(driver).registration(testData.getTestData("registrationPage.username") + timeStamp, testData.getTestData("registrationPage.password"))
                .validateUserRegisteredsuccessfully(testData.getTestData("registrationPage.successMessage"));
    }

    @BeforeClass
    public void beforeClass() {
        driver = new SHAFT.GUI.WebDriver();
        driver.browser().navigateToURL("https://demoblaze.com/index.html");
        testData = new SHAFT.TestData.JSON("registration.json");
    }


    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }


}
