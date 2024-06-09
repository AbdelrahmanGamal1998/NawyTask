package DemoPlazeTest;

import DemoPlazePages.LoginPage;
import DemoPlazePages.ProductsPage;
import DemoPlazePages.RegistrationPage;
import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProductsPageTest {
    private SHAFT.GUI.WebDriver driver;
    private SHAFT.TestData.JSON testData;

    @Test(description = "Verify navigation to the Test Cases page from the homepage")
    public void verifyTestCasePage() {
        new LoginPage(driver).login(testData.getTestData("login.username"), testData.getTestData("login.password"));
        new ProductsPage(driver).chooseCategory()
                .validateProductAvailable(testData.getTestData("productsPage.productName"))
                .chooseProduct()
                .validateProductdetailsdisplayed(testData.getTestData("productsPage.productName"))
                .addProductToCart()
                .validateCartPageAndProductdetailsdisplayed(testData.getTestData("productsPage.productName"))
                .fillPurchaseFormDetails(testData.getTestData("purchaseFormDetails.name"), testData.getTestData("purchaseFormDetails.country"), testData.getTestData("purchaseFormDetails.city"), testData.getTestData("purchaseFormDetails.creditCard"), testData.getTestData("purchaseFormDetails.month"), testData.getTestData("purchaseFormDetails.year"))
                .validatePurchaseOrderSuccesssMessage(testData.getTestData("successMessage"));
    }
    @BeforeClass
    public void beforeClass() {
        driver = new SHAFT.GUI.WebDriver();
        driver.browser().navigateToURL("https://demoblaze.com/index.html");
        testData = new SHAFT.TestData.JSON("product.json");
    }
    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }


}
