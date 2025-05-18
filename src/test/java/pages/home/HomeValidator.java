package pages.home;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomeValidator extends HomePage {

    public HomeValidator(WebDriver driver) {
        super(driver);
    }

    // Validaciones reutilizando los locators
    public void validateTitleIsDisplayed() {
        boolean isDisplayed = driver.findElement(title).isDisplayed();
        Assert.assertTrue(isDisplayed, "El título de la página  está visible");
    }

    public void validateMenuIsVisible() {
        boolean isVisible = driver.findElement(menuButton).isDisplayed();
        Assert.assertTrue(isVisible, "El botón de menú está visible");
    }
}
