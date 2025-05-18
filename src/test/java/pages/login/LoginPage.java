package pages.login;

import pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    protected WebDriver driver;

    // Locators
    protected By usernameInput = By.id("user-name");
    protected By passwordInput = By.id("password");
    protected By loginButton = By.id("login-button");
    protected By errorMessageLabel = By.cssSelector("[data-test='error']");
    protected By loginTitleLabel = By.className("login_logo");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void enterUsername(String username) {
        driver.findElement(usernameInput).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLogin() {
        wait.until(driver -> driver.findElement(loginButton).isDisplayed());
        click(loginButton);
    }

    // Get text or status
    public String getErrorMessage() {
        return driver.findElement(errorMessageLabel).getText();
    }

    public boolean isLoginTitleVisible() {
        return driver.findElement(loginTitleLabel).isDisplayed();
    }
}
