package steps.login;

import drivers.DriverManager;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.home.HomeValidator;
import pages.login.LoginPage;
import pages.login.LoginValidator;

public class LoginSteps {

    WebDriver driver = DriverManager.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    LoginValidator loginValidator = new LoginValidator(driver);
    HomeValidator homeValidator = new HomeValidator(driver);


    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("the user enters valid username {string} and password {string}")
    public void the_user_enters_valid_username_and_password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("clicks on the login button")
    public void clicks_on_the_login_button() {
        loginPage.clickLogin();
    }

    @Then("the user should be redirected to the home page")
    public void the_user_should_be_redirected_to_the_home_page() {
        homeValidator.validateTitleIsDisplayed();
    }

    @When("the user enters invalid username or password")
    public void the_user_enters_invalid_username_or_password() {
        loginPage.enterUsername("invalid_user");
        loginPage.enterPassword("wrong_password");
    }

    @Then("an error message {string} should be displayed")
    public void an_error_message_should_be_displayed(String expectedMessage) {
        loginValidator.validateErrorMessage(expectedMessage);
    }

    @When("the user clicks on the login button without filling in the fields")
    public void the_user_clicks_on_the_login_button_without_filling_in_the_fields() {
        loginPage.clickLogin();
    }

    @Then("a required field warning {string} should be shown")
    public void a_required_field_warning_should_be_shown(String expectedMessage) {
        loginValidator.validateErrorMessage(expectedMessage);
    }
}
