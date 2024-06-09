package DemoPlazePages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LogOutPage {
    /**
     * @author Abdelrahman Gamal
     */
//******** Variables ********
    private final SHAFT.GUI.WebDriver driver;
    //******** Locators ********
    private final By logOutLink = By.id("logout2");

    //******** Constructor ********
    public LogOutPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    @Step("User logout from demoblaze Website")
    public LogOutPage logOut() {
        driver.element().click(logOutLink);
        return this;
    }
}
