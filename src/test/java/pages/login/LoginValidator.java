package pages.login;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginValidator extends LoginPage {

    public LoginValidator(WebDriver driver) {
        super(driver);
    }


    public void validateErrorMessage(String expectedMessage) {
        String actualMessage = getErrorMessage();
        Assert.assertEquals(actualMessage.trim(), expectedMessage.trim(), "Error message does match");
    }

    public void validateLoginTitleVisible() {
        Assert.assertTrue(isLoginTitleVisible(), "Login title is visible");
    }
}
