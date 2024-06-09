package DemoPlazePages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ProductsPage {

    /**
     * @author Abdelrahman Gamal
     */
//******** Variables ********
    private final SHAFT.GUI.WebDriver driver;
    //******** Locators ********
    private final By categoriesList = By.id("cat");
    private final By category = By.xpath("//a[text()='Monitors']");
    private final By cartLink = By.id("cartur");
    private final By product = By.xpath("//a[text()='Apple monitor 24']");
    private final By addToCartBtn =By.xpath("//a[text()='Add to cart']");
    private final By placeOrderBtn =By.xpath("//button[text()='Place Order']");
    private final By placeOrderName = By.id("name");
    private final By placeOrderCountry = By.id("country");
    private final By placeOrderCity= By.id("city");
    private final By placeOrderMonth= By.id("month");
    private final By placeOrderYear= By.id("year");
    private final By placeOrderCard= By.id("card");
    private final By cartPage= By.cssSelector("div.col-lg-8 > h2");
    private final By cartProduct= By.xpath("//tr[@class='success']/td[2]");

    private final By productTitle= By.xpath("//h2[@class='name']");
    private final By purchaseOrderButton= By.xpath(" //button[text()='Purchase']");
    private final By purchaseSuccessMesssage= By.xpath("//div[@class='sa-icon sa-success animate']/following-sibling::h2");
    //******** Constructor ********
    public ProductsPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    @Step("User Successfully create an order for an Apple monitor 24 from demoblaze Website")
    public ProductsPage chooseCategory() {
        driver.element().click(category);
        return this;
    }

    public ProductsPage chooseProduct() {
        driver.element().click(product);
        return this;
    }

    public ProductsPage addProductToCart() {
        driver.element().click(addToCartBtn);
        driver.element().alert().acceptAlert();
        driver.element().click(cartLink);
        return this;
    }

    @Step("User Successfully fill Purchase Form Details for an Apple monitor 24 from demoblaze Website")
    public ProductsPage fillPurchaseFormDetails(String name ,String country ,String city ,String card ,String month,String year) {
        driver.element().click(placeOrderBtn);
        driver.element().type(placeOrderName,name);
        driver.element().type(placeOrderCountry,country);
        driver.element().type(placeOrderCity,city);
        driver.element().type(placeOrderCard,card);
        driver.element().type(placeOrderMonth,month);
        driver.element().type(placeOrderYear,year);
        driver.element().click(purchaseOrderButton);
        return this;
    }

    //******** Assertions ********
    @Step("validate On Purchase Order Successs Message ")
    public ProductsPage  validatePurchaseOrderSuccesssMessage(String successMessage){
        driver.element().assertThat(purchaseSuccessMesssage).text().isEqualTo(successMessage).perform();
        return this;
    }
    @Step("Validate that Monitor is available in the monitors list  ")
    public ProductsPage  validateProductAvailable(String productName){
        driver.verifyThat().element(product).isVisible().perform();
        driver.element().assertThat(product).text().isEqualTo(productName).perform();
        return this;
    }

    @Step("Validate that product details is displayed correctly with correct product ")
    public ProductsPage  validateProductdetailsdisplayed(String productName){
        driver.verifyThat().element(productTitle).isVisible().perform();
        driver.element().assertThat(productTitle).text().isEqualTo(productName).perform();
        return this;
    }
    @Step("Validate that cart page is displayed correctly with correct product ")
    public ProductsPage  validateCartPageAndProductdetailsdisplayed(String productName){
        driver.verifyThat().element(cartPage).isVisible().perform();
        driver.element().assertThat(cartProduct).text().isEqualTo(productName).perform();
        return this;
    }



}
