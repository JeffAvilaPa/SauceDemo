package pages.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class HomePage extends BasePage {
    protected WebDriver driver;

    protected By title = By.cssSelector(".title");
    protected By menuButton = By.id("react-burger-menu-btn");
    protected By logoutButton = By.id("logout_sidebar_link");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openMenu() {
        wait.until(driver -> driver.findElement(menuButton).isDisplayed());
        click(menuButton);
    }

    public void clickLogout() {
        wait.until(driver -> driver.findElement(logoutButton).isDisplayed());
        click(logoutButton);
    }
}
