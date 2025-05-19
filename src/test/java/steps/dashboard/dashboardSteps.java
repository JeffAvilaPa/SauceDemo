package steps.dashboard;

import drivers.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.dashboard.DashboardPage;
import pages.dashboard.DashboardValidator;

public class dashboardSteps {
    private WebDriver driver = DriverManager.getDriver();
    private DashboardPage dashboardPage = new DashboardPage(driver);
    private DashboardValidator dashboardValidator = new DashboardValidator(dashboardPage);

    @Then("the dashboard should be visible")
    public void the_dashboard_should_be_visible() {
        dashboardValidator.validateDashboardIsLoaded();
    }

    @Then("the page title should be {string}")
    public void the_page_title_should_be(String expectedTitle) {
        dashboardValidator.validatePageTitle(expectedTitle);
    }

    @Then("there should be {int} products displayed")
    public void there_should_be_products_displayed(int expectedCount) {
        dashboardValidator.validateProductCount(expectedCount);
    }

    @And("selects {string} from the sort dropdown")
    public void selects_from_the_sort_dropdown(String option) {
        dashboardPage.selectSortOption(option);
    }

    @And("the products should be sorted by name in descending order")
    public void the_products_should_be_sorted_by_name_descending() {
        dashboardValidator.validateProductNameOrderDescending();
    }

    @And("the products should be sorted by price in ascending order")
    public void the_products_should_be_sorted_by_price_ascending() {
        dashboardValidator.validateProductPriceOrderAscending();
    }

    @And("the products should be sorted by price in descending order")
    public void the_products_should_be_sorted_by_price_descending() {
        dashboardValidator.validateProductPriceOrderDescending();
    }

}
