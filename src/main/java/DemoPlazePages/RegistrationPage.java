package DemoPlazePages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RegistrationPage {

    /**
     * @author Abdelrahman Gamal
     */
//******** Variables ********
    private final SHAFT.GUI.WebDriver driver;
    //******** Locators ********
    private final By signUpLink = By.id("signin2");
    String formattedDateTime;
    private final By userName = By.id("sign-username");
    private final By password = By.id("sign-password");
    private final By signUpBtn = By.xpath("//button[contains(text(),'Sign up')]");

    //******** Constructor ********
    public RegistrationPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    @Step("User SignUp To demoblaze Website")
    public RegistrationPage registration(String username ,String userPassword) {
        driver.element().click(signUpLink);
        driver.element().type(userName,username);
        driver.element().type(password,userPassword);
        driver.element().click(signUpBtn);
        return this;
    }

    //******** Assertions ********
    @Step("validate that the User registered successfully ")
    public RegistrationPage  validateUserRegisteredsuccessfully(String alertText){
        String alert =driver.element().alert().getAlertText();
        Assert.assertEquals(alert, alertText);
        return this;
    }


}
