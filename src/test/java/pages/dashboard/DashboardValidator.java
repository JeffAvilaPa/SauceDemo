package pages.dashboard;

import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DashboardValidator {
    private final DashboardPage dashboardPage;

    public DashboardValidator(DashboardPage dashboardPage) {
        this.dashboardPage = dashboardPage;
    }

    public void validateDashboardIsLoaded() {
        Assert.assertTrue(dashboardPage.isDashboardLoaded(), "El dashboard  está visible.");
    }

    public void validatePageTitle(String expectedTitle) {
        Assert.assertEquals(dashboardPage.getPageTitle(), expectedTitle, "El título del dashboard  coincide.");
    }

    public void validateProductCount(int expectedCount) {
        Assert.assertEquals(dashboardPage.getNumberOfProducts(), expectedCount, "El número de productos  coincide.");
    }

    public void validateProductNameOrderDescending() {
        List<String> actualNames = dashboardPage.getProductNames();
        List<String> expected = new ArrayList<>(actualNames);
        expected.sort(java.util.Collections.reverseOrder());
        Assert.assertEquals(actualNames, expected, "Los productos no están ordenados por nombre (Z-A)");
    }

    public void validateProductPriceOrderAscending() {
        List<Double> actualPrices = dashboardPage.getProductPrices();
        List<Double> expected = new ArrayList<>(actualPrices);
        expected.sort(Comparator.naturalOrder());
        Assert.assertEquals(actualPrices, expected, "Los productos  están ordenados por precio de menor a mayor");
    }

    public void validateProductPriceOrderDescending() {
        List<Double> actualPrices = dashboardPage.getProductPrices();
        List<Double> expected = new ArrayList<>(actualPrices);
        expected.sort(Comparator.reverseOrder());
        Assert.assertEquals(actualPrices, expected, "Los productos no están ordenados por precio de mayor a menor");
    }
}
