package DemoPlazePages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginPage {
/**
 * @author Abdelrahman Gamal
 */
//******** Variables ********
private final SHAFT.GUI.WebDriver driver;
    //******** Locators ********
    private final By logInLink = By.id("login2");
    private final By loggedUser= By.cssSelector("#nameofuser");
    private final By userName = By.id("loginusername");
    private final By password = By.id("loginpassword");
    private final By closeBtn = By.xpath("//div[@class='modal-footer']//button[contains(text(),'Close')]");
    private final By loginBtn = By.xpath("//div[@class='modal-footer']//button[contains(text(),'Log in')]");

    //******** Constructor ********
    public LoginPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    @Step("User login To demoblaze Website")
    public LoginPage login(String username ,String userPassword) {
        driver.element().click(logInLink);
        driver.element().type(userName,username);
        driver.element().type(password,userPassword);
        driver.element().click(loginBtn);
        driver.element().waitToBeInvisible(loginBtn);
        driver.browser().refreshCurrentPage();
        return this;
    }
    //******** Assertions ********
    @Step("validate that the User registered successfully ")
    public LoginPage  validateTheLoggedUser(String user){

        driver.element().waitToBeInvisible(loggedUser);
       driver.element().assertThat(loggedUser).text().contains(user).perform();
        return this;
    }



}
