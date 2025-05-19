package pages.dashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.base.BasePage;

import java.util.List;
import java.util.stream.Collectors;

import static drivers.DriverManager.getDriver;

public class DashboardPage extends BasePage {

    private WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    private By inventoryTitle = By.className("title");
    private By productList = By.className("inventory_item");
    private By sortDropdown = By.className("product_sort_container");
    private By productTitles = By.className("inventory_item_name");
    private By productPrices = By.className("inventory_item_price");

    public String getPageTitle() {
        return driver.findElement(inventoryTitle).getText();
    }

    public int getNumberOfProducts() {
        return driver.findElements(productList).size();
    }

    public boolean isDashboardLoaded() {
        return driver.findElement(inventoryTitle).isDisplayed();
    }

    public void selectSortOption(String optionText) {
        WebElement dropdownElement = driver.findElement(sortDropdown);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(optionText);
    }

    public List<String> getProductNames() {
        List<WebElement> elements = getDriver().findElements(productTitles);
        return elements.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<Double> getProductPrices() {
        List<WebElement> elements = getDriver().findElements(productPrices);
        return elements.stream()
                .map(e -> e.getText().replace("$", "").trim())
                .map(Double::parseDouble)
                .collect(Collectors.toList());
    }


}
